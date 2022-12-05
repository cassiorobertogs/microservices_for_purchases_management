package br.com.order.resource.client

import br.com.order.application.dto.ProductRequestDTO
import br.com.order.domain.entity.Product
import br.com.order.domain.gateway.ProductGateway
import br.com.order.resource.client.feign.ProductFeign
import feign.FeignException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.webjars.NotFoundException

@Component
class ProductMock(private val client: ProductFeign): ProductGateway {
    override fun reserve(products: List<Product>): Double {
        try {
            return client.reserve(products.map(::ProductRequestDTO))
        } catch (e:FeignException) {
            throw when (e.status()) {
                HttpStatus.NOT_FOUND.value() -> NotFoundException("produto indisponível")
                else -> e
            }
        }
    }
}