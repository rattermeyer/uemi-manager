import { relations } from "drizzle-orm/relations";
import { benutzerInBetreuung, benutzerRolleInBetreuung, rolleInBetreuung } from "./schema";

export const benutzerRolleInBetreuungRelations = relations(benutzerRolleInBetreuung, ({one}) => ({
	benutzerInBetreuung: one(benutzerInBetreuung, {
		fields: [benutzerRolleInBetreuung.benutzerUuid],
		references: [benutzerInBetreuung.uuid]
	}),
	rolleInBetreuung: one(rolleInBetreuung, {
		fields: [benutzerRolleInBetreuung.rolleUuid],
		references: [rolleInBetreuung.uuid]
	}),
}));

export const benutzerInBetreuungRelations = relations(benutzerInBetreuung, ({many}) => ({
	benutzerRolleInBetreuungs: many(benutzerRolleInBetreuung),
}));

export const rolleInBetreuungRelations = relations(rolleInBetreuung, ({many}) => ({
	benutzerRolleInBetreuungs: many(benutzerRolleInBetreuung),
}));