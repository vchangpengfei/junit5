
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.apiGuardian(): Dependency =
        create("org.apiguardian:apiguardian-api:${Versions.apiGuardian}")

fun DependencyHandler.openTest4J(): Dependency =
        create("org.opentest4j:opentest4j:${Versions.ota4j}")

fun DependencyHandler.kotlinStdlib(): Dependency =
        create("org.jetbrains.kotlin:kotlin-stdlib")

fun DependencyHandler.assertJCore(): Dependency =
        create("org.assertj:assertj-core:${Versions.assertJ}")

fun DependencyHandler.mockito(): ExternalModuleDependency =
        create("org.mockito:mockito-junit-jupiter:${Versions.mockito}") as ExternalModuleDependency

fun DependencyHandler.log4JCore(): Dependency =
        create("org.apache.logging.log4j:log4j-core:${Versions.log4j}")

fun DependencyHandler.log4JJUL(): Dependency =
        create("org.apache.logging.log4j:log4j-jul:${Versions.log4j}")

fun DependencyHandler.classGraph(): Dependency =
        create("io.github.classgraph:classgraph:${Versions.classgraph}")

fun DependencyHandler.jruby(): Dependency =
        create("org.jruby:jruby-complete:${Versions.jruby}")

fun DependencyHandler.groovy(): ExternalModuleDependency =
        create("org.codehaus.groovy:groovy-all:${Versions.groovy}") as ExternalModuleDependency

fun DependencyHandler.junit4(): Dependency =
        create("junit:junit:${Versions.junit4}")

fun DependencyHandler.univocityParsers(): Dependency =
        create("com.univocity:univocity-parsers:${Versions.univocity}")

fun DependencyHandler.picocli(): Dependency =
        create("info.picocli:picocli:${Versions.picocli}")
