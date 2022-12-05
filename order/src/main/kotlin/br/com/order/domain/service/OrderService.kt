package br.com.order.domain.service

import br.com.order.domain.entity.Order
import br.com.order.domain.entity.Product
import br.com.order.domain.enum.OrderStatus
import br.com.order.domain.enum.OrderStatus.*
import br.com.order.domain.exception.ProductNotFoundException
import br.com.order.domain.gateway.OrderDatabaseGateway
import br.com.order.domain.gateway.PaymentGateway
import br.com.order.domain.gateway.ProductGateway
import org.springframework.stereotype.Service
import org.webjars.NotFoundException

@Service
class OrderService(
    private val orderDatabaseGateway: OrderDatabaseGateway,
    private val productGateway: ProductGateway,
    private val paymentGateway: PaymentGateway,
) {
    fun startOrder(products: List<Product>) {
        var order = Order(
            products = products,
            userId = "teste"
        )

        orderDatabaseGateway.create(order)

        var reserved = 0.0

        try {
            reserved = productGateway.reserve(products)
        } catch (e: NotFoundException) {
            throw ProductNotFoundException(
                "Que pena, este produto está indisponível... que tal conferir estes?",
                listOf(Product("321"))
            )
        }

        order = order.copy(
            value = reserved, status = if (reserved > 0) {
                PRODUCT_RESERVED
            } else {
                PRODUCT_UNAVAILABLE
            }
        )

        orderDatabaseGateway.update(order)

        if (order.status == PRODUCT_RESERVED) {
            paymentGateway.send(order.id, order.value)
            orderDatabaseGateway.update(order.copy(status = SEND_TO_PAYMENT))
        }
    }
}