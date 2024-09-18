CREATE TABLE IF NOT EXISTS "benutzer" (
	"id" uuid PRIMARY KEY NOT NULL,
	"email" varchar(255) NOT NULL,
	"passwort" varchar(255) NOT NULL,
	"username" varchar(255) NOT NULL,
	CONSTRAINT "benutzer_email_unique" UNIQUE("email"),
	CONSTRAINT "benutzer_username_unique" UNIQUE("username")
);
--> statement-breakpoint
CREATE INDEX IF NOT EXISTS "idx_benutzer_email" ON "benutzer" USING btree ("email");--> statement-breakpoint
CREATE INDEX IF NOT EXISTS "idx_benutzer_username" ON "benutzer" USING btree ("username");