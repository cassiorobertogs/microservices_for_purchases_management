package br.com.order.domain.entity

import br.com.order.domain.enum.OrderStatus
import java.util.UUID

data class Order(
        val id: String = UUID.randomUUID().toString(),
        val value: Double = 0.0,
        val status: OrderStatus = OrderStatus.CREATED,
        val userId: String,
        val products: List<Product>

)