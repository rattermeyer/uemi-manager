import {Authenticator} from "remix-auth";
import {commitSession, getSession, sessionStorage} from "./session.server";
import {redirect} from "@remix-run/node";
import {FormStrategy} from "remix-auth-form";
import {getValidatedFormData} from "remix-hook-form";
import {type User, userResolver} from "~/models/auth";
import {kysely} from "~/db.server";
import * as argon2 from "argon2";
import {invariant} from '@remix-run/router/history';

// define the user model

export const authenticator = new Authenticator<User>(sessionStorage);

authenticator.use(
	new FormStrategy(async ({form }) => {
		const email = form.get("email")?.toString() || "";
		const password = form.get("password")?.toString() || "";
		const hashedPassword = await argon2.hash(password);
		const user = await kysely
			.selectFrom("benutzer")
			.select(["email", "passwort as password"])
			.where((eb) =>
				eb("email", "=", email).and("passwort", "=", hashedPassword),
			)
			.executeTakeFirst;
		return {email, password, user};
	}),
);

export async function requireUserSession(request: Request) {
	// get the session
	const cookie = request.headers.get("cookie");
	const session = await getSession(cookie);
	// validate the session, `userId` is just an example, use whatever value you
	// put in the session when the user authenticated
	if (!session.has(authenticator.sessionKey)) {
		// if there is no user session, redirect to login
		session.flash("targetURL", request.url);
		throw redirect("/login", {
			headers: { "Set-Cookie": await commitSession(session) },
		});
	}

	return session;
}
