plugins {
	`kotlin-library-conventions`
}

description = "JUnit Jupiter API"

dependencies {
	api(apiGuardian())
	api(openTest4J())

	api(project(":junit-platform-commons"))

	compileOnly(kotlinStdlib())
}
