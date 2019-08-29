plugins {
	`java-library-conventions`
}

description = "JUnit Platform Engine API"

dependencies {
	api(apiGuardian())
	api(openTest4J())
	api(project(":junit-platform-commons"))
}
