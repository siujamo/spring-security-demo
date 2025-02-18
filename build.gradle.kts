plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

/**
 * Artefact version.
 */
// This value is set in file gradle.properties, or manually set in each command.
val artefactVersion: String by project

group = "io.github.siujamo"
version = artefactVersion

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.mybatis-flex:mybatis-flex-spring-boot3-starter:1.10.7")
    implementation("com.zaxxer:HikariCP")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.auth0:java-jwt:4.4.0")
    implementation(platform("com.onixbyte:devkit-bom:1.8.0"))
    implementation("com.onixbyte:guid")
    implementation("com.onixbyte:simple-jwt-facade")
    implementation("com.onixbyte:simple-jwt-authzero")
    implementation("com.onixbyte:simple-jwt-spring-boot-starter")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
