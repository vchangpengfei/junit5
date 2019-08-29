plugins {
	`java-library-conventions`
}

description = "JUnit Platform Reporting"

dependencies {
	api(apiGuardian())
	api(project(":junit-platform-launcher"))
}
