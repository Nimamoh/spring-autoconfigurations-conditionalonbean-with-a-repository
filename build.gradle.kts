
plugins {
    kotlin("jvm") version "1.4.21" apply false
    kotlin("plugin.spring") version "1.4.21" apply false
    kotlin("plugin.jpa") version "1.4.21" apply false
    kotlin("plugin.allopen") version "1.4.21" apply false

    id("org.springframework.boot") version "2.4.1" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
    configurations.all {
        resolutionStrategy {}
    }
}

subprojects {
    group = "net.nimamoh.so"
    version = "0.0.1-SNAPSHOT"
}