package br.com.order.application.controller

import br.com.order.application.dto.ProductRequestDTO
import br.com.order.domain.entity.Product
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/product")
class ProductController {
    @PostMapping("/reservation")
    fun reserve(@RequestBody products: List <ProductRequestDTO>) {
throw ResponseStatusException(HttpStatus.NOT_FOUND, "trata aí esse erro")
    }

}