plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.3"
}

group = "io.intino.itrules"
version = "1.0-SNAPSHOT"

sourceSets {
    val main by getting {
        java {
            srcDirs("src/main/java", "gen")
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

    patchPluginXml {
        sinceBuild.set("232")
        untilBuild.set("242.*")
    }

//    signPlugin {
//        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
//        privateKey.set(System.getenv("PRIVATE_KEY"))
//        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
//    }

    dependencies {
        implementation("io.intino.itrules:dsl:1.1.0")
    }

//    publishPlugin {
//        token.set(System.getenv("PUBLISH_TOKEN"))
//    }
}
