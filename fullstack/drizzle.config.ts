import { defineConfig } from "drizzle-kit";

export default defineConfig({
	schema: "./drizzle/schema.ts",
	out: "./drizzle",
	dialect: "postgresql",
	dbCredentials: {
        ssl: false,
        url: process.env.DATABASE_URL || "postgresql://betreuung_admin:betreuung_admin@localhost:5432/betreuung?currentSchema=betreuung"
	},
    
});
