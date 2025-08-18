plugins {
    id("java")
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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}