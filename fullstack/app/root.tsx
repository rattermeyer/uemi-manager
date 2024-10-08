import "@mantine/core/styles.css";
import "@mantine/dates/styles.css"; //if using mantine date picker features
import "mantine-react-table/styles.css"; //make sure MRT styles were imported in your app root (once)
import "@mantine/notifications/styles.css";
import {AppShell, Burger, ColorSchemeScript, Flex, List, MantineProvider, ScrollArea,} from "@mantine/core";
import {useDisclosure} from "@mantine/hooks";
import {Notifications} from "@mantine/notifications";
import {json, type LoaderFunctionArgs, type MetaFunction,} from "@remix-run/node";
import {
	Links,
	Meta,
	Outlet,
	Scripts,
	ScrollRestoration,
	useRouteError,
	useRouteLoaderData,
} from "@remix-run/react";
import {useTranslation} from "react-i18next";
import {useChangeLanguage} from "remix-i18next/react";
import i18next from "~/i18next.server";
import {theme} from "~/theme";
import classes from "~/components/navbar/navbar-nested.module.css";
import { IconAdjustments, IconCalendarStats, IconFileAnalytics, IconGauge, IconLock, IconNotes, IconPresentationAnalytics } from "@tabler/icons-react";
import {LinksGroup} from '~/components/navbar/navbar-links-group';

export const meta: MetaFunction = () => {
	return [
		{ title: "Betreuung App" },
		{
			name: "description",
			content: "A demo app to showcase remix and some other libraries",
		},
	];
};

export const loader = async ({ request }: LoaderFunctionArgs) => {
	const locale = (await i18next.getLocale(request)) || "en";
	return json({ locale });
};

export function Layout({ children }: { children: React.ReactNode }) {
	const { locale = "en" } = { ...useRouteLoaderData<typeof loader>("root") };
	const { i18n } = useTranslation();
	const [opened, { toggle }] = useDisclosure();
	const error = useRouteError();

	// This hook will change the i18n instance language to the current locale
	// detected by the loader, this way, when we do something to change the
	// language, this locale will change and i18next will load the correct
	// translation files
	useChangeLanguage(locale);
	const mockdata = [
	  { label: 'Dashboard', icon: IconGauge, link: '/' },
	  {
	    label: 'Betreuungszeiten',
	    icon: IconNotes,
	    initiallyOpened: false,
	    links: [
	      { label: 'Kalender', link: '/' },
	      { label: 'Wochen', link: '/' },
	      { label: 'Tage', link: '/' },
	      { label: 'Heute', link: '/betreuungszeiten/heute' },
	    ],
	  },
	  {
	    label: 'Admin',
	    icon: IconCalendarStats,
	    links: [
	      { label: 'Benutzer', link: '/admin/benutzer/list' },
	      { label: 'Schüler', link: '/schueler' },
	    ],
	  },
	  {
	    label: 'Benutzerkonto',
	    icon: IconLock,
	    links: [
	      { label: 'Passwort ändern', link: '/' },
	    ],
	  },
	];

	const links = mockdata.map((item) => <LinksGroup {...item} key={item.label} />);

	return (
		<html lang={locale} dir={i18n.dir()}>
			<head>
				<title>Remix Demo App</title>
				<meta charSet="utf-8" />
				<meta name="viewport" content="width=device-width, initial-scale=1" />
				<Meta />
				<Links />
				<ColorSchemeScript />
			</head>
			<body>
				<MantineProvider theme={theme}>
					<Notifications position={"top-right"} /> {/* for mantine */}
					<AppShell
						header={{ height: 60 }}
						navbar={{
							width: 300,
							breakpoint: "sm",
							collapsed: { mobile: !opened },
						}}
						padding="md"
					>
						<AppShell.Header>
							<Flex gap={"md"} justify={"flex-start"} direction={"row"}>
								<Burger
									opened={opened}
									onClick={toggle}
									hiddenFrom="sm"
									size="sm"
								/>
								<div>Logo</div>
								<Flex
									gap={"md"}
									justify={"flex-end"}
									direction={"row"}
									flex={1}
								/>
							</Flex>
						</AppShell.Header>

						<AppShell.Navbar p={"md"}>
      						<ScrollArea className={classes.links}>
      						  <div className={classes.linksInner}>{links}</div>
      						</ScrollArea>
						</AppShell.Navbar>
						<AppShell.Main>{children}</AppShell.Main>
					</AppShell>
				</MantineProvider>
				<ScrollRestoration />
				<Scripts />
			</body>
		</html>
	);
}

export default function Root() {
	return <Outlet />;
}

export function ErrorBoundary() {
	// why this is not rendered automatically, but requires specific handling in Root Component, I don't know
	const error = useRouteError();
	console.error(error);
	return (
		<>
			<h1>ErrorBoundary: Root</h1>
			<p>Something bad has happened</p>
		</>
	);
}
