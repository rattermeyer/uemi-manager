import type {LoaderFunctionArgs} from "@remix-run/node";
import {json} from "@remix-run/node";
import {useLoaderData} from "@remix-run/react";
import weekday from 'dayjs/plugin/weekday'
import weekOfYear from 'dayjs/plugin/weekOfYear'
import dayjs from 'dayjs';
import {Table} from "@mantine/core";
import {IconCheck} from '@tabler/icons-react';

export const loader = async ({params}: LoaderFunctionArgs) => {
    const {jahr, woche, schueler} = params;
    return json({jahr, woche, schueler});
}

export default function Betreuungszeiten() {
    const {jahr, woche, schueler} = useLoaderData<typeof loader>();
    dayjs.extend(weekday);
    dayjs.extend(weekOfYear);
    const startOfWeek = dayjs().week(5).startOf('week').format('DD.MM.YYYY').toString();
    const endOfWeek = dayjs().week(5).endOf('week').format('DD.MM.YYYY').toString();
    return (
        <div>
            <h1>Betreuungszeiten</h1>
            <p>Jahr: {jahr}</p>
            <p>Woche: {woche}({startOfWeek}-{endOfWeek})</p>
            <p>Schüler: {schueler}</p>
            <Table striped={true} highlightOnHover={true}>
                <Table.Thead>
                    <Table.Tr>
                        <Table.Th>Wochentag</Table.Th>
                        <Table.Th colSpan={3}>Frühbetreuung</Table.Th>
                        <Table.Th colSpan={3}>Mittagsbetreuung</Table.Th>
                    </Table.Tr>
                    <Table.Tr>
                        <Table.Th></Table.Th>
                        <Table.Th></Table.Th>
                        <Table.Th>von</Table.Th>
                        <Table.Th>bis</Table.Th>
                        <Table.Th></Table.Th>
                        <Table.Th>von</Table.Th>
                        <Table.Th>bis</Table.Th>
                    </Table.Tr>

                </Table.Thead>
                <Table.Tbody>
                    <Table.Tr>
                        <Table.Td>Montag</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>07:15</Table.Td>
                        <Table.Td>08:00</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>12:30</Table.Td>
                        <Table.Td>13:15</Table.Td>
                    </Table.Tr>
                    <Table.Tr>
                        <Table.Td>Dienstag</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>07:15</Table.Td>
                        <Table.Td>08:00</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>12:30</Table.Td>
                        <Table.Td>13:15</Table.Td>
                    </Table.Tr>
                    <Table.Tr>
                        <Table.Td>Mittwoch</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>07:15</Table.Td>
                        <Table.Td>08:00</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>12:30</Table.Td>
                        <Table.Td>13:15</Table.Td>
                    </Table.Tr>
                    <Table.Tr>
                        <Table.Td>Donnerstag</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>07:15</Table.Td>
                        <Table.Td>08:00</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>12:30</Table.Td>
                        <Table.Td>13:15</Table.Td>
                    </Table.Tr>
                    <Table.Tr>
                        <Table.Td>Freitag</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>07:15</Table.Td>
                        <Table.Td>08:00</Table.Td>
                        <Table.Td><IconCheck/></Table.Td>
                        <Table.Td>12:30</Table.Td>
                        <Table.Td>13:15</Table.Td>
                    </Table.Tr>
                </Table.Tbody>
            </Table>
        </div>
    );
}
