plugins {
	`kotlin-library-conventions`
	id("com.github.johnrengelman.shadow")
}

apply(from = "$rootDir/gradle/testing.gradle.kts")

description = "JUnit Jupiter Params"

dependencies {
	api(apiGuardian())

	api(project(":junit-jupiter-api"))

	shadowed(univocityParsers())

	testImplementation(project(":junit-platform-testkit"))
	testImplementation(project(":junit-jupiter-engine"))
	testImplementation(project(":junit-platform-launcher"))
	testImplementation(project(":junit-platform-runner"))

	compileOnly(kotlinStdlib())
	testImplementation(kotlinStdlib())
}

tasks {
	shadowJar {
		archiveClassifier.set("")
		configurations = listOf(project.configurations["shadowed"])
		exclude("META-INF/maven/**")
		relocate("com.univocity", "org.junit.jupiter.params.shadow.com.univocity")
		from(projectDir) {
			include("LICENSE-univocity-parsers.md")
			into("META-INF")
		}
	}
	test {
		// in order to run the test against the shadowJar
		classpath = classpath - sourceSets.main.get().output + files(shadowJar.get().archiveFile)
		dependsOn(shadowJar)
	}
	jar {
		enabled = false
		dependsOn(shadowJar)
	}
}
