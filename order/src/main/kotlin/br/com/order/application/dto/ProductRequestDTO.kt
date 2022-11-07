package br.com.order.application.dto

import br.com.order.domain.entity.Product

data class ProductRequestDTO(
        val id: String
) {
        fun toDomain() = Product(id = id)
}