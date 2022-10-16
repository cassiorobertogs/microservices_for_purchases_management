package br.com.order.domain.gateway

import br.com.order.domain.entity.Order

interface OrderDatabaseGateway {
    fun create(order: Order)
    fun update(order: Order)
}