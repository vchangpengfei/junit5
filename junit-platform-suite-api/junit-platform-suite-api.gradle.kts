plugins {
	`java-library-conventions`
}

description = "JUnit Platform Suite API"

dependencies {
	api(platform(project(":dependencies")))

	api("org.apiguardian:apiguardian-api")
}
