import { zodResolver } from "@hookform/resolvers/zod";
import { Box, Button, PasswordInput, Stack, TextInput } from "@mantine/core";
import { Form, json, redirect } from "@remix-run/react";
import { getValidatedFormData, useRemixForm } from "remix-hook-form";
import { z } from "zod";
import { kysely } from "~/db.server";
import type { FieldErrors } from "react-hook-form";
import argon2 from "argon2";

const benutzerCreateScheme = z.object({
	benutzername: z.string(),
	email: z.string().email(),
	name: z.string(),
	vorname: z.string(),
});

type BenutzerCreateForm = z.infer<typeof benutzerCreateScheme>;

const resolver = zodResolver(benutzerCreateScheme);

export const loader = async () => {
	return null;
};

export const action = async ({ request }: ActionFunctionArgs) => {
	const {
		errors,
		data,
		receivedValues: defaultValues,
	} = await getValidatedFormData<BenutzerCreateForm>(request, resolver);
	if (errors) {
		// The keys "errors" and "defaultValues" are picked up automatically by useRemixForm
		return json({ errors, defaultValues });
	}
	const customErrors: FieldErrors<BenutzerCreateForm> = {};

	const result = await kysely.transaction().execute(async (trx) => {
        // Check and set in a transaction
		const benutzerByName = await trx
			.selectFrom("benutzer")
			.where("benutzername", "=", data.benutzername)
			.executeTakeFirst();
		if (benutzerByName) {
			customErrors.benutzername = {
				type: "custom",
				message: "Benutzername bereits vergeben",
			};
		}
		const benutzerByEmail = await trx
			.selectFrom("benutzer")
			.selectAll()
			.where("email", "=", data.email)
			.executeTakeFirst();
		if (benutzerByEmail) {
			customErrors.email = {
				type: "custom",
				message: "Email bereits vergeben",
			};
		}
		if (Object.keys(customErrors).length === 0) {
			return  await trx.insertInto("benutzer").values({ ...data, passwort_hash: await argon2.hash('changeme')}).execute();
		}
	});

	if (Object.keys(customErrors).length > 0) {
		return json({ errors: customErrors, defaultValues });
	}

	return redirect("/");
};

export default function AdminBenutzerCreate() {
	const {
		handleSubmit,
		register,
		formState: { errors },
	} = useRemixForm<BenutzerCreateForm>({
		resolver,
		mode: "onSubmit",
	});
	return (
		<>
			<h2>Benutzer anlegen</h2>
			<Box w="400">
				<Form onSubmit={handleSubmit} method="post">
					<Stack gap="4">
						<TextInput
							label="Benutzername"
							{...register("benutzername")}
							error={errors.benutzername?.message}
						/>
						<TextInput
							label="Email"
							{...register("email")}
							error={errors.email?.message}
						/>
						<TextInput
							label="Vorname"
							{...register("vorname")}
							error={errors.vorname?.message}
						/>
						<TextInput
							label="Name"
							{...register("name")}
							error={errors.name?.message}
						/>
						<Button type="submit">Anlegen</Button>
					</Stack>
				</Form>
			</Box>
		</>
	);
}
