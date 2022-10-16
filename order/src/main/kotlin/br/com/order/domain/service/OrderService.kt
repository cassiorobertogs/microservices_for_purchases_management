package br.com.order.domain.service

import br.com.order.domain.entity.Order
import br.com.order.domain.entity.Product
import br.com.order.domain.enum.OrderStatus
import br.com.order.domain.enum.OrderStatus.*
import br.com.order.domain.gateway.OrderDatabaseGateway
import br.com.order.domain.gateway.PaymentGateway
import br.com.order.domain.gateway.ProductGateway
import org.springframework.stereotype.Service

@Service
class OrderService(
        private val orderDatabaseGateway: OrderDatabaseGateway,
        private val productGateway: ProductGateway,
        private val paymentGateway: PaymentGateway,
) {
    fun startOrder(products: List <Product>) {
        var order = Order(
                products = products,
                userId = "teste"
        )

        orderDatabaseGateway.create(order)

        val reserved = productGateway.reserve(products)

        order = order.copy(value = reserved, status = if (reserved > 0) {
            PRODUCT_RESERVED
            } else {
                PRODUCT_UNAVAILABLE
        })

        orderDatabaseGateway.update(order)

        if (order.status == PRODUCT_RESERVED) {
            paymentGateway.send(order.id, order.value)
            orderDatabaseGateway.update(order.copy(status = SEND_TO_PAYMENT))
        }
    }
}