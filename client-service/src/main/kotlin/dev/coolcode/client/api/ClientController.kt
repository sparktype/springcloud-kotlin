package dev.coolcode.client.api

import dev.coolcode.client.service.ClientService
import dev.coolcode.domain.Client
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
@RequestMapping("/api/client")
class ClientController(val service: ClientService) {

  @GetMapping("/{id}")
  fun detail(@PathVariable id: Long) = ResponseEntity.ok(service.detail(id))

  @PostMapping
  fun create(@RequestBody client: Client) = service.create(client).let {
    createdResponseEntity(this.javaClass, "detail", arrayOf(it.id)).body(it)
  }

  @PutMapping("/{id}")
  fun modify(@PathVariable id: Long, @RequestBody client: Client) =
    service.modify(id, client).let {
      createdResponseEntity(this.javaClass, "detail", arrayOf(it.id)).body(it)
    }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): ResponseEntity<Void> = service.remove(id).let {
    ResponseEntity.noContent().build()
  }
}
