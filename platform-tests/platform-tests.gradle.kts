plugins {
	`java-library-conventions`
	id("me.champeau.gradle.jmh")
}

apply(from = "$rootDir/gradle/testing.gradle.kts")

dependencies {
	api(platform(project(":dependencies")))

	// --- Things we are testing --------------------------------------------------
	testImplementation(project(":junit-platform-commons"))
	testImplementation(project(":junit-platform-console"))
	testImplementation(project(":junit-platform-engine"))
	testImplementation(project(":junit-platform-launcher"))

	// --- Things we are testing with ---------------------------------------------
	testImplementation(project(":junit-platform-runner"))
	testImplementation(project(":junit-platform-testkit"))
	testImplementation(project(path = ":junit-jupiter-engine", configuration = "testArtifacts"))
	testImplementation("org.apiguardian:apiguardian-api")

	// --- Test run-time dependencies ---------------------------------------------
	testRuntimeOnly(project(":junit-vintage-engine"))
	testRuntimeOnly("org.codehaus.groovy:groovy-all") {
		because("`ReflectionUtilsTests.findNestedClassesWithInvalidNestedClassFile` needs it")
	}

	// --- https://openjdk.java.net/projects/code-tools/jmh/ -----------------------
	jmh("org.openjdk.jmh:jmh-core") {
		exclude(module = "jopt-simple")
	}
	jmhAnnotationProcessor(platform(project(":dependencies")))
	jmhAnnotationProcessor("org.openjdk.jmh:jmh-generator-annprocess")
	jmh(project(":junit-jupiter-api"))
	jmh("junit:junit")
}

jmh {
	jmhVersion = Versions.jmh

	duplicateClassesStrategy = DuplicatesStrategy.WARN
	fork = 0 // Too long command line on Windows...
	warmupIterations = 1
	iterations = 5
}

tasks {
	test {
		useJUnitPlatform {
			excludeTags("exclude")
		}
		jvmArgs = listOf("-Xmx1g")
	}
	checkstyleJmh { // use same style rules as defined for tests
		configFile = rootProject.file("src/checkstyle/checkstyleTest.xml")
	}
}

eclipse {
	classpath {
		plusConfigurations.add(project(":junit-platform-console").configurations["shadowed"])
	}
}

idea {
	module {
		scopes["PROVIDED"]!!["plus"]!!.add(project(":junit-platform-console").configurations["shadowed"])
	}
}
