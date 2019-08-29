plugins {
	`java-library-conventions`
}

description = "JUnit Platform Test Kit"

dependencies {
	api(apiGuardian())
	api(assertJCore())
	api(openTest4J())

	api(project(":junit-platform-launcher"))
}
