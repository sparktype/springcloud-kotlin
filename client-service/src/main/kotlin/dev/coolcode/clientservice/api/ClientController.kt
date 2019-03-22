package dev.coolcode.clientservice.api

import dev.coolcode.clientservice.service.ClientService
import dev.coolcode.common.domain.Client
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
@RequestMapping("/api/client")
class ClientController(val service: ClientService) {

  @GetMapping("/{id}")
  fun detail(@PathVariable id: Long) = ResponseEntity.ok(service.detail(id))

  @PostMapping
  fun create(@RequestBody client: Client) = service.create(client).let {
    ResponseEntity.created(
      fromMethodName(uri(it.id)
    ).body(it)
  }

  @PutMapping("/{id}")
  fun modify(@PathVariable id: Long, @RequestBody client: Client) =
    service.modify(id, client)?.let {
      ResponseEntity.created(
        fromMethodName(this.javaClass, "detail", it.id).build().toUri()
      ).body(it)
    }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Long): ResponseEntity<Void> = service.remove(id).let {
    ResponseEntity.noContent().build()
  }

  private fun uri(id: Long): URI {
    return fromMethodName(this.javaClass, "detail", id).build().toUri()
  }

}
