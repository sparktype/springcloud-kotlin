package dev.coolcode.common.api

import dev.coolcode.common.domain.User
import dev.coolcode.common.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodName
import java.net.URI


@RestController
@RequestMapping("/api/user")
class UserController(val service: UserService) {

  @GetMapping("/{id}")
  fun detail(@PathVariable id: Long) = ResponseEntity.ok(service.detail(id))

  @PostMapping
  fun create(@RequestBody user: User) =
    service.create(user).let { ResponseEntity.created(userUri(it.id)).body(it) }

  @PutMapping("/{id}")
  fun modify(@PathVariable id: Long, user: User) =
    service.modify(id, user).let { ResponseEntity.created(userUri(it.id)).body(it) }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): ResponseEntity<Void> = service.remove(id).let {
    ResponseEntity.noContent().build()
  }

  private fun userUri(id: Long): URI = fromMethodName(
    UserController::class.java, "detail", id
  ).build().toUri()

}