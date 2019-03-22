plugins {
  id("org.springframework.boot").version("2.1.3.RELEASE")
  kotlin("plugin.spring").version("1.3.21")
  kotlin("jvm").version("1.3.21")
}

repositories {
  mavenCentral()
}

subprojects {
  apply {
    plugin("idea")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("org.jetbrains.kotlin.jvm")
    plugin("org.jetbrains.kotlin.plugin.spring")
  }

  tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.apiVersion = "1.3"
    kotlinOptions.languageVersion = "1.3"
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
  }

  tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.apiVersion = "1.3"
    kotlinOptions.languageVersion = "1.3"
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
  }

  repositories {
    mavenCentral()
  }

  dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
  }
}