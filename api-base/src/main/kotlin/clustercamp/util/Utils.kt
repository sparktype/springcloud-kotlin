package clustercamp.util


import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodName


val createdResponseEntity: (Class<Any>, String, Array<Any>) -> ResponseEntity.BodyBuilder = { clazz, methodName, args ->
    ResponseEntity.created(fromMethodName(clazz, methodName, args).build().toUri())
}

