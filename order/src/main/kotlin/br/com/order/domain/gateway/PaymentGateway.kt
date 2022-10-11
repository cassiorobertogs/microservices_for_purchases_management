package br.com.order.domain.gateway

interface PaymentGateway {
    fun send(orderId: String, orderValue: Double)
}