plugins {
	`java-library-conventions`
}

description = "JUnit Platform Runner"

dependencies {
	api(junit4())
	api(apiGuardian())
	api(project(":junit-platform-launcher"))
	api(project(":junit-platform-suite-api"))
}
