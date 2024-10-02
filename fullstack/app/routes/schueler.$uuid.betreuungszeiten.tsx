import { Outlet } from "@remix-run/react";

export const loader = async () => {
    return null;
}

export default function SchuelerBetreuungszeitenLayout() {
    return (
        <div>
            <h2>Betreuungszeiten</h2>
            <Outlet/>
        </div>
    );
}