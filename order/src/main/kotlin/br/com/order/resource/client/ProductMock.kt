package br.com.order.resource.client

import br.com.order.domain.entity.Product
import br.com.order.domain.gateway.ProductGateway
import org.springframework.stereotype.Component

@Component
class ProductMock: ProductGateway {
    override fun reserve(products: List<Product>): Boolean {
        return true
    }
}