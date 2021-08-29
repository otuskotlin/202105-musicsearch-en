plugins {
    kotlin("jvm") version "1.5.30"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation(kotlin("test-junit"))

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}