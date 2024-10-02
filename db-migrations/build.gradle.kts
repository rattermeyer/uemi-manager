plugins {
    id("org.liquibase.gradle") version "2.2.1"
    id("co.uzzu.dotenv.gradle") version "4.0.0"
}

repositories {
    mavenCentral()
}

ext {
    set("jdbcUsername", env.DB_USER.orNull()) // overwritten per environment
    set("jdbcPassword", env.DB_PASSWORD.orNull()) // overwritten per environment
    set("jdbcUrl", env.DB_URL.orNull())
}

ext["jooqVersion"] = "3.19.10"
ext["postgresqlVersion"] = "42.7.2"


dependencies {
    liquibaseRuntime("org.liquibase:liquibase-core:4.29.0")
    liquibaseRuntime("org.postgresql:postgresql:${property("postgresqlVersion")}")
    liquibaseRuntime("info.picocli:picocli:4.7.6")

}


liquibase {
    activities {
        register("betreuung") {
            this.arguments = mapOf(
                "searchPath" to "${projectDir}/src/main/resources/db/changelog/betreuung",
                "changelogFile" to "changelog.xml",
                "url" to "${project.ext["jdbcUrl"]}?currentSchema=betreuung,extensions",
                "username" to project.ext["jdbcUsername"],
                "password" to project.ext["jdbcPassword"],
            )
        }
    }
}
