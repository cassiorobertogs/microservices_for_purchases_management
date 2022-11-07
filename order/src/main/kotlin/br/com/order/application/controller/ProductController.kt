package br.com.order.application.controller

import br.com.order.application.dto.ProductRequestDTO
import br.com.order.domain.entity.Product
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController {
    @PostMapping("/reservation")
    fun reserve(@RequestBody products: List <ProductRequestDTO>) = 6.0

}