pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

rootProject.name = "spring-cloud-kotlin"
include(
  "common",
  "user-service",
  "client-service"
)
