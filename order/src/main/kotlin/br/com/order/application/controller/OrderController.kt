package br.com.order.application.controller

import br.com.order.application.dto.ProductRequestDTO
import br.com.order.domain.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(val orderService: OrderService) {
    @PostMapping
    fun create(@RequestBody products: List<ProductRequestDTO>) {
        products.map{
            it.toDomain()
        }.also(orderService::startOrder)

    }
}