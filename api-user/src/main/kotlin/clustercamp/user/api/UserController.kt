package clustercamp.user.api

import clustercamp.user.domain.User
import clustercamp.user.service.UserService
import clustercamp.util.createdResponseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


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