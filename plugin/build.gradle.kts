plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.24"
    id("org.jetbrains.intellij") version "1.17.3"
}

group = "io.intino.itrules"
version = "1.0-SNAPSHOT"

sourceSets {
    val main by getting {
        java {
            srcDirs("src/main/java", "gen")
        }
        resources {
            srcDirs("src/main/resources")
        }
    }

    val test by getting {
        java {
            srcDirs("src/test/java")
        }
        resources {
            srcDirs("src/test/resources")
        }
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://artifactory.intino.io/artifactory/releases")
    }
}

intellij {
    version.set("2023.2.6")
    type.set("IC")
    plugins.set(listOf("java"))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("232")
        untilBuild.set("242.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    dependencies {
        // Dependencia de JUnit para pruebas unitarias
        implementation("junit:junit:4.13.2")
        implementation("io.intino.itrules:dsl:1.1.0")
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
