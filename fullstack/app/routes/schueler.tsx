import { authenticator } from "~/services/auth.server";
import type { LoaderFunctionArgs } from "@remix-run/node";
import { Outlet } from "@remix-run/react";

export const loader = async ({ request }: LoaderFunctionArgs) => {
  await authenticator.isAuthenticated(request, { failureRedirect: "/login" });

    return null;
}

export default function Schueler () {
    return (
        <>
            <h1>Schüler</h1>
            <Outlet />
        </>
    );
}