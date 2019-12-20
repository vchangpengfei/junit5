import java.io.File;
import java.util.spi.ToolProvider;

class GenerateJavadoc {
  public static void main(String[] args) {
    ToolProvider.findFirst("javadoc").orElseThrow().run(System.out, System.err,

        "-d", "build/javadoc",

        "-encoding", "UTF-8",
        "-locale", "en",
        "-doctitle", "JUnit 5 API",
        "-protected",
        "-notimestamp",
        "-Xdoclint:none",

        "--add-stylesheet", "documentation/src/javadoc/junit-stylesheet.css",

        "-tag", "apiNote:a:API Note:",
        "-tag", "implNote:a:Implementation Note:",

        // "-link", "https://docs.oracle.com/javase/8/docs/api/",
        "-link", "https://docs.oracle.com/en/java/javase/11/docs/api/",
        "-link", "https://ota4j-team.github.io/opentest4j/docs/1.2.0/api/",
        "-link", "https://apiguardian-team.github.io/apiguardian/docs/1.1.0/api/",
        "-link", "https://junit.org/junit4/javadoc/4.12/",
        "-link", "https://joel-costigliola.github.io/assertj/core-8/api/",

        "--module-path", "src/build", // TODO Refer to Gradle-managed JARs

        "-group", "Jupiter", "org.junit.jupiter*",
        "-group", "Platform", "org.junit.platform*",
        "-group", "Vintage", "org.junit.vintage*",

        "--module", String.join(",",
            "org.junit.platform.commons",
            "org.junit.platform.commons",
            "org.junit.platform.console",
            "org.junit.platform.engine",
            "org.junit.platform.launcher",
            "org.junit.platform.reporting",
            "org.junit.platform.suite.api",
            "org.junit.platform.testkit",
            "org.junit.jupiter",
            "org.junit.jupiter.api",
            "org.junit.jupiter.engine",
            "org.junit.jupiter.migrationsupport",
            "org.junit.jupiter.params",
            "org.junit.vintage.engine"),

        "--add-reads", "org.junit.jupiter.params=univocity.parsers",

        "--module-source-path", String.join(File.pathSeparator,
            "junit-platform-commons/src/module",
            "junit-platform-console/src/module",
            "junit-platform-engine/src/module",
            "junit-platform-launcher/src/module",
            "junit-platform-reporting/src/module",
            "junit-platform-suite-api/src/module",
            "junit-platform-testkit/src/module",
            "junit-jupiter/src/module",
            "junit-jupiter-api/src/module",
            "junit-jupiter-engine/src/module",
            "junit-jupiter-migrationsupport/src/module",
            "junit-jupiter-params/src/module",
            "junit-vintage-engine/src/module"),

        "--patch-module", "org.junit.platform.commons=junit-platform-commons/src/main/java",
        "--patch-module", "org.junit.platform.console=" + String.join(File.pathSeparator, "junit-platform-console/src/main/java", "junit-platform-console/src/main/java9"),
        "--patch-module", "org.junit.platform.engine=junit-platform-engine/src/main/java",
        "--patch-module", "org.junit.platform.launcher=junit-platform-launcher/src/main/java",
        "--patch-module", "org.junit.platform.reporting=junit-platform-reporting/src/main/java",
        "--patch-module", "org.junit.platform.suite.api=junit-platform-suite-api/src/main/java",
        "--patch-module", "org.junit.platform.testkit=junit-platform-testkit/src/main/java",
        "--patch-module", "org.junit.jupiter.api=junit-jupiter-api/src/main/java",
        "--patch-module", "org.junit.jupiter.engine=junit-jupiter-engine/src/main/java",
        "--patch-module", "org.junit.jupiter.migrationsupport=junit-jupiter-migrationsupport/src/main/java",
        "--patch-module", "org.junit.jupiter.params=junit-jupiter-params/src/main/java",
        "--patch-module", "org.junit.vintage.engine=junit-vintage-engine/src/main/java"
    );
  }
}