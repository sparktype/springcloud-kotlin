package dev.coolcode.common.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Client(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long,
  var clientId: String,
  var name: String
)