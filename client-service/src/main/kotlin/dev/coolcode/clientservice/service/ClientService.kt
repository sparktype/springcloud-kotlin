package dev.coolcode.clientservice.service

import dev.coolcode.clientservice.domain.Client
import dev.coolcode.clientservice.exception.ClientNotFoundException
import dev.coolcode.clientservice.repository.ClientRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ClientService(val repository: ClientRepository) {

  fun detail(id: Long): Client =
    repository.findByIdOrNull(id) ?: throw ClientNotFoundException("ID $id not found")

  fun create(user: Client): Client = repository.save(user)

  fun modify(id: Long, user: Client): Client {
    return repository.findByIdOrNull(id)
      ?.let {
        it.copy(name = user.name)
        return repository.save(it)
      } ?: throw ClientNotFoundException("ID $id not found")
  }

  fun remove(id: Long) = repository.deleteById(id)
}