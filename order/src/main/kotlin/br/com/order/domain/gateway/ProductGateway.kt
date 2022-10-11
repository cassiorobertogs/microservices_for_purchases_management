package br.com.order.domain.gateway

import br.com.order.domain.entity.Product

interface ProductGateway {
    fun reserve(products: List<Product>): Double
}