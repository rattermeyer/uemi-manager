import { json } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";
import { access } from "fs";
import { useMemo } from "react";
import { kysely } from "~/db.server";
import { requireUserSession } from "~/services/auth.server";
import { type MRT_ColumnDef, MantineReactTable, useMantineReactTable } from "mantine-react-table";

export const loader = async () => {
	// TODO only allow admins
	const benutzer = await kysely
		.selectFrom("benutzer")
		.select(["uuid", "benutzername", "email", "vorname", "name"])
		.execute();
	return json({ benutzer });
};

export default function AdminBenutzerList() {
	const { benutzer } = useLoaderData<typeof loader>();
	type Benutzer = (typeof benutzer)[0];
	const columns = useMemo<MRT_ColumnDef<Benutzer>[]>(
		() => [
			{
				accessorKey: "name",
				header: "Name",
			},
			{
				accessorKey: "vorname",
				header: "Vorname",
			},
			{
				accessorKey: "email",
				header: "Email",
			},
			{
				accessorKey: "benutzername",
				header: "Benutzername",
			},
		],
		[],
	);
    const table = useMantineReactTable({
        columns,
        data: benutzer,
    });
    return (
        <MantineReactTable table={table} />
    );
}
