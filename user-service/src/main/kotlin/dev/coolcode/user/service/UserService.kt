package dev.coolcode.user.service

import dev.coolcode.domain.User
import dev.coolcode.exception.UserNotFoundException
import dev.coolcode.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

  fun detail(id: Long): User =
    repository.findByIdOrNull(id) ?: throw UserNotFoundException(
      "ID $id not found"
    )

  fun create(user: User): User = repository.save(user)

  fun modify(id: Long, user: User): User {
    return repository.findByIdOrNull(id)
      ?.let {
        it.copy(name = user.name, password = user.password)
        return repository.save(it)
      } ?: throw UserNotFoundException("ID $id not found")
  }

  fun remove(id: Long) = repository.deleteById(id)

}