plugins {
	`java-library-conventions`
}

description = "JUnit Platform Launcher"

dependencies {
	api(platform(project(":dependencies")))

	api("org.apiguardian:apiguardian-api")

	api(project(":junit-platform-engine"))
}
