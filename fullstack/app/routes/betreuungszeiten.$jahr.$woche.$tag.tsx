import { Tabs } from "@mantine/core";
import { json } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";

export const loader = async () => {
	return json({ jahr: 2021, woche: 5, tag: "Montag" });
};

export default function BetreuungszeitenTag() {
	const { jahr, woche, tag } = useLoaderData<typeof loader>();
	return (
		<>
			<Tabs defaultValue="mittags" variant="outline">
				<Tabs.List>
					<Tabs.Tab value="morgens">Morgens</Tabs.Tab>
					<Tabs.Tab value="mittags">Mittags</Tabs.Tab>
				</Tabs.List>
				<Tabs.Panel value="morgens">Übersicht Morgens</Tabs.Panel>
				<Tabs.Panel value="mittags">Übersicht Mittags</Tabs.Panel>
			</Tabs>
		</>
	);
}
