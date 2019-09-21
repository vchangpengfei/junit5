plugins {
	`java-library-conventions`
}

description = "JUnit Platform Reporting"

dependencies {
	api(platform(project(":dependencies")))

	api("org.apiguardian:apiguardian-api")

	api(project(":junit-platform-launcher"))
}
