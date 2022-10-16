package br.com.order.resource.database

import br.com.order.domain.entity.Order
import br.com.order.domain.gateway.OrderDatabaseGateway
import org.springframework.stereotype.Component

@Component
class OrderMock: OrderDatabaseGateway {
    override fun create(order: Order) {
        TODO("Not yet implemented")
    }

    override fun update(order: Order) {
        TODO("Not yet implemented")
    }
}