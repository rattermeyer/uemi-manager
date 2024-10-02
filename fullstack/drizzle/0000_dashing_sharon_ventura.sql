-- Current sql file was generated after introspecting the database
-- If you want to run this migration please uncomment this code before executing migrations
/*
CREATE SCHEMA "betreuung";
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "betreuung"."databasechangelog" (
	"id" varchar(255) NOT NULL,
	"author" varchar(255) NOT NULL,
	"filename" varchar(255) NOT NULL,
	"dateexecuted" timestamp NOT NULL,
	"orderexecuted" integer NOT NULL,
	"exectype" varchar(10) NOT NULL,
	"md5sum" varchar(35),
	"description" varchar(255),
	"comments" varchar(255),
	"tag" varchar(255),
	"liquibase" varchar(20),
	"contexts" varchar(255),
	"labels" varchar(255),
	"deployment_id" varchar(10)
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "betreuung"."databasechangeloglock" (
	"id" integer PRIMARY KEY NOT NULL,
	"locked" boolean NOT NULL,
	"lockgranted" timestamp,
	"lockedby" varchar(255)
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "betreuung"."session" (
	"id" uuid DEFAULT uuid_generate_v7() NOT NULL,
	"data" json NOT NULL,
	"expires" timestamp with time zone DEFAULT (now() + '1 day'::interval) NOT NULL
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "betreuung"."benutzer" (
	"uuid" uuid PRIMARY KEY DEFAULT uuid_generate_v7() NOT NULL,
	"benutzername" varchar(40) NOT NULL,
	"email" varchar(254) NOT NULL,
	"name" varchar(40) NOT NULL,
	"vorname" varchar(40) NOT NULL,
	"passwort" varchar(60) NOT NULL,
	CONSTRAINT "uq_benutzer_benutzername" UNIQUE("benutzername"),
	CONSTRAINT "uq_benutzer_email" UNIQUE("email")
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "betreuung"."rolle" (
	"uuid" uuid PRIMARY KEY DEFAULT uuid_generate_v7() NOT NULL,
	"name" varchar(40) NOT NULL,
	CONSTRAINT "uq_rolle_name" UNIQUE("name")
);
--> statement-breakpoint
CREATE TABLE IF NOT EXISTS "betreuung"."benutzer_rolle" (
	"benutzer_uuid" uuid NOT NULL,
	"rolle_uuid" uuid NOT NULL,
	CONSTRAINT "pk_benutzer_rolle" PRIMARY KEY("benutzer_uuid","rolle_uuid")
);
--> statement-breakpoint
DO $$ BEGIN
 ALTER TABLE "betreuung"."benutzer_rolle" ADD CONSTRAINT "fk_benutzer_rolle_benutzer" FOREIGN KEY ("benutzer_uuid") REFERENCES "betreuung"."benutzer"("uuid") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;
--> statement-breakpoint
DO $$ BEGIN
 ALTER TABLE "betreuung"."benutzer_rolle" ADD CONSTRAINT "fk_benutzer_rolle_rolle" FOREIGN KEY ("rolle_uuid") REFERENCES "betreuung"."rolle"("uuid") ON DELETE no action ON UPDATE no action;
EXCEPTION
 WHEN duplicate_object THEN null;
END $$;

*/