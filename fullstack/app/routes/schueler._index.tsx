import { ActionIcon, Group } from "@mantine/core";
import { json, NavLink, useLoaderData } from "@remix-run/react";
import { IconCalendarTime, IconDetails } from "@tabler/icons-react";
import dayjs from "dayjs";
import {
	MantineReactTable,
	type MRT_ColumnDef,
	useMantineReactTable,
} from "mantine-react-table";
import { useMemo } from "react";
import { kysely } from "~/db.server";
import { authenticator, requireUserSession } from "~/services/auth.server";
import weekOfYear from 'dayjs/plugin/weekOfYear'

export const loader = async ({ request }) => {
	const session = await requireUserSession(request);
	const user = await authenticator.isAuthenticated(session);
	const schueler = await kysely.selectFrom("schueler").selectAll().execute();
	return json({ schueler });
};

export default function SchuelerList() {
	const { schueler } = useLoaderData<typeof loader>();
    dayjs.extend(weekOfYear);
	type Schueler = (typeof schueler)[0];
	const columns = useMemo<MRT_ColumnDef<Schueler>[]>(
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
				accessorKey: "klasse",
				header: "Klasse",
			},
			{
				accessorKey: "geburtsdatum",
				header: "Geburtsdatum",
			},
		],
		[],
	);
	const table = useMantineReactTable({
		columns,
		data: schueler,
		enableRowActions: true,
		getRowId: (row) => row.uuid,
		positionActionsColumn: "last",
		renderRowActions: (row) => {
			return (
				<Group>
					<ActionIcon component={NavLink} to={`/schueler/${row.row.id}`}>
						<IconDetails />
					</ActionIcon>
					<ActionIcon
						component={NavLink}
						to={`/schueler/${row.row.id}/betreuungszeiten/${dayjs().year()}/${dayjs().week()}`}
					>
						<IconCalendarTime />
					</ActionIcon>
				</Group>
			);
		},
	});
	return (
		<>
			<NavLink to="/schueler/create">Schüler erstellen</NavLink>
			<MantineReactTable table={table} />
		</>
	);
}
