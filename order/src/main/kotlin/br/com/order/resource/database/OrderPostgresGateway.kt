package br.com.order.resource.database

import br.com.order.domain.entity.Order
import br.com.order.domain.gateway.OrderDatabaseGateway
import br.com.order.resource.database.repository.OrderPostgresRepository
import br.com.order.resource.database.table.OrderTable
import org.springframework.stereotype.Component

@Component
class OrderPostgresGateway(
    private val repository: OrderPostgresRepository
): OrderDatabaseGateway {
    override fun create(order: Order) {
        repository.save(OrderTable(order))
    }

    override fun update(order: Order) {
        repository.save(OrderTable(order))
    }
}