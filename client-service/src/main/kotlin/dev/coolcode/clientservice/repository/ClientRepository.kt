package dev.coolcode.clientservice.repository

import dev.coolcode.clientservice.domain.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : CrudRepository<Client, Long>