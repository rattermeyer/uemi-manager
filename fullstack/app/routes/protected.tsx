import {json, type LoaderFunction} from '@remix-run/node';
import {authenticator, requireUserSession} from '~/services/auth.server';

export const loader: LoaderFunction = async ({ request }) => {
    const session = await requireUserSession(request);
    const user = await authenticator.isAuthenticated(session);
    return json({ user });
}

export default function Index() {
    return (
        <div>
            <h1>Default Protected Route</h1>
            <p>This route is protected.</p>
        </div>
    );
}
