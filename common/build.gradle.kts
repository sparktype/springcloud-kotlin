dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")

  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.bootJar {
  enabled = false
}

tasks.jar {
  enabled = true
}