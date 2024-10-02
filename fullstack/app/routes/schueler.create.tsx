import { zodResolver } from "@hookform/resolvers/zod";
import { Box, Button, Checkbox, Stack, TextInput, Text } from "@mantine/core";
import { DateInput } from "@mantine/dates";
import type { LoaderFunctionArgs } from "@remix-run/node";
import { Form, json, redirect, redirectDocument, replace } from "@remix-run/react";
import dayjs from "dayjs";
import { uuid, vector } from "drizzle-orm/pg-core";
import { Controller } from "react-hook-form";
import { getValidatedFormData, useRemixForm } from "remix-hook-form";
import { z } from "zod";
import { kysely } from "~/db.server";
import { requireUserSession } from "~/services/auth.server";

const schulerCreateSchema = z.object({
	vorname: z.string(),
	name: z.string(),
	geburtsdatum: z.coerce.date(),
	klasse: z.string().min(1).max(2),
	vertragVon: z.coerce.date(),
	account: z
		.object({
			vorname: z.string(),
			name: z.string(),
			uuid: z.string().uuid(),
		})
		.nullish(),
	weitere: z.coerce.boolean().nullish(),
});

type SchuelerCreateForm = z.infer<typeof schulerCreateSchema>;

const resolver = zodResolver(schulerCreateSchema);

export const loader = async ({ request }: LoaderFunctionArgs) => {
	await requireUserSession(request);
	return null;
};

export const action = async ({ request }: LoaderFunctionArgs) => {
	await requireUserSession(request);
	const {
		errors,
		data,
		receivedValues: defaultValues,
	} = await getValidatedFormData<SchuelerCreateForm>(request, resolver);
	if (errors) {
		return json({ errors, defaultValues });
	}
	const customErrors: FieldErrors<SchuelerCreateForm> = {};
	const result = await kysely.transaction().execute(async (trx) => {
		const sameSchueler = await trx
			.selectFrom("schueler")
			.selectAll()
			.where((eb) =>
				eb.and({
					vorname: data.vorname,
					name: data.name,
					geburtsdatum: data.geburtsdatum,
				}),
			)
			.executeTakeFirst();
		if (sameSchueler) {
			customErrors.root = {
				type: "custom",
				message: `Schüler (${data.vorname} ${data.name}, ${dayjs(data.geburtsdatum).format("DD.MM.YYYY")}) bereits vorhanden`,
			};
		} else {
			const schueler = await trx
				.insertInto("schueler")
				.values({
					name: data.name,
					vorname: data.vorname,
					geburtsdatum: data.geburtsdatum,
					klasse: data.klasse,
					vertrag_von: data.vertragVon,
				})
				.returning(["uuid"])
				.executeTakeFirstOrThrow();
			await trx.insertInto("standardzeiten").values([
				{
					schueler_uuid: schueler.uuid,
					wochentag: 'MO',
					vormittag_beginn: "07:15",
					vormittag_ende: "08:00",
					mittag_beginn: "11:45",
					mittag_ende: "14:00",

				},
				{
					schueler_uuid: schueler.uuid,
					wochentag: 'DI',
					vormittag_beginn: "07:15",
					vormittag_ende: "08:00",
					mittag_beginn: "11:45",
					mittag_ende: "14:00",

				},
				{
					schueler_uuid: schueler.uuid,
					wochentag: 'MI',
					vormittag_beginn: "07:15",
					vormittag_ende: "08:00",
					mittag_beginn: "11:45",
					mittag_ende: "14:00",

				},
				{
					schueler_uuid: schueler.uuid,
					wochentag: 'DO',
					vormittag_beginn: "07:15",
					vormittag_ende: "08:00",
					mittag_beginn: "11:45",
					mittag_ende: "14:00",

				},
				{
					schueler_uuid: schueler.uuid,
					wochentag: 'FR',
					vormittag_beginn: "07:15",
					vormittag_ende: "08:00",
					mittag_beginn: "11:45",
					mittag_ende: "14:00",

				},
            ]).execute();
            return schueler;
		}
	});
    if (Object.keys(customErrors).length > 0) {
        console.log('customErrors', customErrors);
        return json({ errors: customErrors, defaultValues });
    } 
    return redirect("/schueler");
};

export default function SchuelerCreate() {
	const {
		register,
		handleSubmit,
		control,
		formState: { isSubmitting, errors },
	} = useRemixForm<SchuelerCreateForm>({});
	return (
		<>
			<h2>Schüler erstellen</h2>
			<Box w={{ base: 200, sm: 400, lg: 500 }}>
                <Text c="red">{errors.root?.message}</Text>
				<Form method="post" onSubmit={handleSubmit}>
					<Stack gap={4}>
						<TextInput
							label="Vorname"
							placeholder="Vorname des Schülers / der Schülerin"
							{...register("vorname")}
							error={errors.vorname?.message}
						/>
						<TextInput
							label="Nachname"
							placeholder="Nachname des Schülers / der Schülerin"
							{...register("name")}
							error={errors.vorname?.message}
						/>
						<Controller
							name="geburtsdatum"
							control={control}
							render={({ field }) => (
								<DateInput
									label="Geburtsdatum"
									{...field}
                                    minDate={dayjs().subtract(10, 'year').toDate()}
                                    maxDate={dayjs().subtract(5, 'year').toDate()}
									error={errors.geburtsdatum?.message}
									valueFormat="MM.DD.YYYY"
                                    withAsterisk={true}
								/>
							)}
						/>
						<TextInput
							label="Klasse"
							placeholder="Klasse des Schülers / der Schülerin"
							{...register("klasse")}
							error={errors.klasse?.message}
						/>
						<Controller
							name="vertragVon"
							control={control}
							render={({ field }) => (
								<DateInput
									label="Vertrag ab"
									{...field}
									error={errors.vertragVon?.message}
									valueFormat="MM.DD.YYYY"
								/>
							)}
						/>
						<Button type="submit" disabled={isSubmitting}>
							Anlegen
						</Button>
					</Stack>
				</Form>
			</Box>
		</>
	);
}
