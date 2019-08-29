plugins {
	`java-library-conventions`
}

description = "JUnit Platform Launcher"

dependencies {
	api(apiGuardian())
	api(project(":junit-platform-engine"))
}
