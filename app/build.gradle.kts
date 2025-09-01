plugins {
    application
    id("org.sonarqube") version "6.2.0.5505"
    checkstyle
}

sonar {
    properties {
        property("sonar.projectKey", "monsterius_java-project-61")
        property("sonar.organization", "monsterius")
    }
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "hexlet.code.App"
    }
}
