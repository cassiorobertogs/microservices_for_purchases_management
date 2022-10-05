package br.com.order.domain.service

import br.com.order.domain.entity.Order
import br.com.order.domain.entity.Product
import br.com.order.domain.enum.OrderStatus
import br.com.order.domain.gateway.OrderDatabaseGateway
import br.com.order.domain.gateway.ProductGateway
import org.springframework.stereotype.Service

@Service
class OrderService(
        val orderDatabaseGateway: OrderDatabaseGateway,
        val productGateway: ProductGateway
) {
    fun startOrder(products: List <Product>) {
        var order = Order(
                products = products,
                userId = "teste"
        )

        orderDatabaseGateway.create(order)

        val reserved = productGateway.reserve(products)

        order = order.copy(status = if (reserved) {
            OrderStatus.PRODUCT_RESERVED
            } else {
                OrderStatus.PRODUCT_UNAVAILABLE
        })
    }
}