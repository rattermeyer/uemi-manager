import { pgTable, varchar, index, uuid } from "drizzle-orm/pg-core"

export const benutzer = pgTable("benutzer", {
	id: uuid("id").primaryKey().notNull(),
	email: varchar("email", { length: 255 }).notNull().unique(),
	passwort: varchar("passwort", { length: 255 }).notNull(),
	username: varchar("username", { length: 255 }).notNull().unique(),
}, (table) => {
	return {
		idx_email: index("idx_benutzer_email").using("btree", table.email),
		idx_username: index("idx_benutzer_username").using("btree", table.username),
	}
});
