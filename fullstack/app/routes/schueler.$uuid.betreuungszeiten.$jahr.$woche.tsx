import {
	ActionFunctionArgs,
	json,
	type LoaderFunctionArgs,
} from "@remix-run/node";
import { Form, NavLink, useLoaderData } from "@remix-run/react";
import { kysely } from "~/db.server";
import { requireUserSession } from "~/services/auth.server";
import {
	ActionIcon,
	Button,
	Flex,
	Group,
	Stack,
	Text,
	ThemeIcon,
} from "@mantine/core";
import dayjs from "dayjs";
import weekYear from "dayjs/plugin/weekYear";
import weekOfYear from "dayjs/plugin/weekOfYear";
import weekday from "dayjs/plugin/weekday";
import "dayjs/locale/de";
import {
	IconChevronCompactLeft,
	IconChevronCompactRight,
	IconClockHour12Filled,
	IconClockHour7Filled,
	IconDoor,
	IconDoorOff,
	IconHomeX,
	IconLock,
	IconLockOpen2,
	IconPillFilled,
} from "@tabler/icons-react";
import {
	MantineReactTable,
	MRT_ColumnDef,
	useMantineReactTable,
} from "mantine-react-table";
import { useMemo } from "react";

export const loader = async ({ request, params }: LoaderFunctionArgs) => {
	await requireUserSession(request);
	const { uuid, jahr, woche } = params;
	const schueler = await kysely
		.selectFrom("schueler")
		.selectAll()
		.where("uuid", "=", uuid)
		.executeTakeFirst();
	dayjs.locale("de");
	dayjs.extend(weekOfYear);
	dayjs.extend(weekday);
	const startOfWeek = dayjs().week(woche).startOf("week").toDate();
	const endOfWeek = dayjs().week(woche).endOf("week").toDate();
	console.log(dayjs().weekYear(), dayjs().week(), startOfWeek, endOfWeek);
	const betreuungszeiten = await kysely
		.selectFrom("schueler_betreuungszeiten")
		.select([
			"datum",
			"geschlossen",
			"krank",
			"keine_fruehbetreuung",
			"keine_mittagsbetreuung",
			"vormittag_beginn",
			"vormittag_ende",
			"mittag_beginn",
			"mittag_ende",
		])
		.where((eb) => eb.between("datum", startOfWeek, endOfWeek))
		.orderBy("datum")
		.execute();
	return json({
		uuid,
		jahr,
		woche,
		schueler,
		startOfWeek,
		endOfWeek,
		betreuungszeiten,
	});
};

export const action = async ({ request }: ActionFunctionArgs) => {
	await requireUserSession(request);
	return json({ success: true });
};

export default function SchuelerBetreuungszeiten() {
	const { schueler, jahr, woche, startOfWeek, endOfWeek, betreuungszeiten } =
		useLoaderData<typeof loader>();
	dayjs.locale("de");
	dayjs.extend(weekOfYear);
	dayjs.extend(weekYear);
	dayjs.extend(weekday);
	const locked = dayjs().isAfter(dayjs(startOfWeek));

	type Betreuungszeit = (typeof betreuungszeiten)[0];
	const columns = useMemo<MRT_ColumnDef<Betreuungszeit>[]>(
		() => [
			{
				accessorKey: "datum",
				header: "Datum",
				Cell: ({ cell }) => (
					<>
						{dayjs(cell.getValue<Date>()).format("dd")},{" "}
						{dayjs(cell.getValue<Date>().toString()).format("DD.MM.YYYY")}
					</>
				),
			},
			{
				accessorKey: "vormittag_beginn",
				header: "Vormittag Beginn",
				Cell: ({ row, cell }) => {
					if (
						!row.original.geschlossen ||
						row.original.krank ||
						row.original.keine_fruehbetreuung
					) {
						return <>{cell.getValue()}</>;
					}
				},
			},
			{
				accessorKey: "vormittag_ende",
				header: "Vormittag Ende",
				Cell: ({ row, cell }) => {
					if (
						!row.original.geschlossen ||
						row.original.krank ||
						row.original.keine_fruehbetreuung
					) {
						return <>{cell.getValue()}</>;
					}
				},
			},
			{
				accessorKey: "mittag_beginn",
				header: "Mittag Beginn",
				Cell: ({ row, cell }) => {
					if (
						!row.original.geschlossen ||
						row.original.krank ||
						row.original.keine_mittagsbetreuung
					) {
						return <>{cell.getValue()}</>;
					}
				},
			},
			{
				accessorKey: "mittag_ende",
				header: "Mittag Ende",
				Cell: ({ row, cell }) => {
					if (
						!row.original.geschlossen ||
						row.original.krank ||
						row.original.keine_mittagsbetreuung
					) {
						return <>{cell.getValue()}</>;
					}
				},
			},
			{
				header: "Besonderheiten",
				Cell: ({ row }) => (
					<>
						{row.original.geschlossen && (
							<ThemeIcon color="red" variant="filled">
								<IconHomeX />
							</ThemeIcon>
						)}
						{row.original.krank && <IconPillFilled color="red" />}
						{row.original.keine_fruehbetreuung && (
							<ThemeIcon>
								<IconClockHour7Filled color="red" />
							</ThemeIcon>
						)}
						{row.original.keine_mittagsbetreuung && (
							<IconClockHour12Filled color="red" />
						)}
					</>
				),
			},
		],
		[],
	);

	const table = useMantineReactTable({
		columns,
		data: betreuungszeiten,
	});

	return (
		<>
			<Text size="xl" fw={700}>
				{schueler?.vorname} {schueler?.name} ({schueler?.klasse})
			</Text>
			<p>Hier stehen die konkreten Betreuungszeiten pro Woche </p>
			<Stack>
				<Flex justify="center">
					<Group>
						<ActionIcon
							variant="outline"
							component={NavLink}
							to={`/schueler/${schueler.uuid}/betreuungszeiten/${jahr}/${woche - 1}`}
						>
							<IconChevronCompactLeft />
						</ActionIcon>
						<Text>
							KW {woche} ({dayjs(startOfWeek).format("DD.MM.YYYY")} -{" "}
							{dayjs(endOfWeek).format("DD.MM.YYYY")})
						</Text>
						<ThemeIcon variant="outline">
							{locked ? <IconLock /> : <IconLockOpen2 />}
						</ThemeIcon>
						<ActionIcon
							variant="outline"
							component={NavLink}
							to={`/schueler/${schueler.uuid}/betreuungszeiten/${jahr}/${Number.parseInt(woche || "0") + 1}`}
						>
							<IconChevronCompactRight />
						</ActionIcon>
					</Group>
				</Flex>
				<MantineReactTable table={table} />
			</Stack>
		</>
	);
}
