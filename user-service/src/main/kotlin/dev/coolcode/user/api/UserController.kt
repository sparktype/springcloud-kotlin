package dev.coolcode.user.api

import dev.coolcode.domain.User
import dev.coolcode.user.service.UserService
import dev.coolcode.util.createdResponseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/user")
class UserController(val service: UserService) {

  @GetMapping("/{id}")
  fun detail(@PathVariable id: Long) = ResponseEntity.ok(service.detail(id))

  @PostMapping
  fun create(@RequestBody user: User) =
    service.create(user).let {
      createdResponseEntity(this.javaClass, "detail", arrayOf(it.id)).body(it)
    }

  @PutMapping("/{id}")
  fun modify(@PathVariable id: Long, user: User) =
    service.modify(id, user).let {
      createdResponseEntity(this.javaClass, "detail", arrayOf(it.id)).body(it)
    }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): ResponseEntity<Void> = service.remove(id).let {
    ResponseEntity.noContent().build()
  }
}