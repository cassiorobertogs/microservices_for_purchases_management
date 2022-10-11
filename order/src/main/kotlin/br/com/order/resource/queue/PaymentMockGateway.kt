package br.com.order.resource.queue

import br.com.order.domain.gateway.PaymentGateway
import org.springframework.stereotype.Component

@Component
class PaymentMockGateway : PaymentGateway {
    override fun send(orderId: String, orderValue: Double) {
        TODO("Not yet implemented")
    }
}