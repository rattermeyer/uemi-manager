import weekday from 'dayjs/plugin/weekday'
import weekOfYear from 'dayjs/plugin/weekOfYear'
import dayjs from 'dayjs';
import {redirect} from '@remix-run/node';

export const loader = async () => {
    dayjs.extend(weekOfYear);
    dayjs.extend(weekday);
    const jahr = dayjs().year();
    const woche = dayjs().week();
    const tag = dayjs().weekday();
    return redirect(`/betreuungszeiten/${jahr}/${woche}/${tag}`);
}
