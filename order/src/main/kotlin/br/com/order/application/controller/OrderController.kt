package br.com.order.application.controller

import br.com.order.application.dto.ProductRequestDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController {
    @PostMapping
    fun create(@RequestBody products: List<ProductRequestDTO>): String  {
        return "Hello world";
    }
}