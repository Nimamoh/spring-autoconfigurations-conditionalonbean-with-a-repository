plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(platform(project(":platform")))

    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}