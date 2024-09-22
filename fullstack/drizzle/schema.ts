import { pgTable, pgSchema, varchar, timestamp, integer, boolean, uuid, json, unique, foreignKey, primaryKey } from "drizzle-orm/pg-core"
  import { sql } from "drizzle-orm"

export const betreuung = pgSchema("betreuung");



export const databasechangelogInBetreuung = betreuung.table("databasechangelog", {
	id: varchar("id", { length: 255 }).notNull(),
	author: varchar("author", { length: 255 }).notNull(),
	filename: varchar("filename", { length: 255 }).notNull(),
	dateexecuted: timestamp("dateexecuted", { mode: 'string' }).notNull(),
	orderexecuted: integer("orderexecuted").notNull(),
	exectype: varchar("exectype", { length: 10 }).notNull(),
	md5Sum: varchar("md5sum", { length: 35 }),
	description: varchar("description", { length: 255 }),
	comments: varchar("comments", { length: 255 }),
	tag: varchar("tag", { length: 255 }),
	liquibase: varchar("liquibase", { length: 20 }),
	contexts: varchar("contexts", { length: 255 }),
	labels: varchar("labels", { length: 255 }),
	deploymentId: varchar("deployment_id", { length: 10 }),
});

export const databasechangeloglockInBetreuung = betreuung.table("databasechangeloglock", {
	id: integer("id").primaryKey().notNull(),
	locked: boolean("locked").notNull(),
	lockgranted: timestamp("lockgranted", { mode: 'string' }),
	lockedby: varchar("lockedby", { length: 255 }),
});

export const sessionInBetreuung = betreuung.table("session", {
	id: uuid("id").default(sql`uuid_generate_v7()`).notNull(),
	data: json("data").notNull(),
	expires: timestamp("expires", { withTimezone: true, mode: 'string' }).default(sql`(now() + '1 day'::interval)`).notNull(),
});

export const benutzerInBetreuung = betreuung.table("benutzer", {
	uuid: uuid("uuid").default(sql`uuid_generate_v7()`).primaryKey().notNull(),
	benutzername: varchar("benutzername", { length: 40 }).notNull(),
	email: varchar("email", { length: 254 }).notNull(),
	name: varchar("name", { length: 40 }).notNull(),
	vorname: varchar("vorname", { length: 40 }).notNull(),
	passwort: varchar("passwort", { length: 60 }).notNull(),
},
(table) => {
	return {
		uqBenutzerBenutzername: unique("uq_benutzer_benutzername").on(table.benutzername),
		uqBenutzerEmail: unique("uq_benutzer_email").on(table.email),
	}
});

export const rolleInBetreuung = betreuung.table("rolle", {
	uuid: uuid("uuid").default(sql`uuid_generate_v7()`).primaryKey().notNull(),
	name: varchar("name", { length: 40 }).notNull(),
},
(table) => {
	return {
		uqRolleName: unique("uq_rolle_name").on(table.name),
	}
});

export const benutzerRolleInBetreuung = betreuung.table("benutzer_rolle", {
	benutzerUuid: uuid("benutzer_uuid").notNull(),
	rolleUuid: uuid("rolle_uuid").notNull(),
},
(table) => {
	return {
		fkBenutzerRolleBenutzer: foreignKey({
			columns: [table.benutzerUuid],
			foreignColumns: [benutzerInBetreuung.uuid],
			name: "fk_benutzer_rolle_benutzer"
		}),
		fkBenutzerRolleRolle: foreignKey({
			columns: [table.rolleUuid],
			foreignColumns: [rolleInBetreuung.uuid],
			name: "fk_benutzer_rolle_rolle"
		}),
		pkBenutzerRolle: primaryKey({ columns: [table.benutzerUuid, table.rolleUuid], name: "pk_benutzer_rolle"}),
	}
});