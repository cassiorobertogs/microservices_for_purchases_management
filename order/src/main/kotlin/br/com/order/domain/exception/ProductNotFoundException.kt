package br.com.order.domain.exception

import br.com.order.domain.entity.Product

class ProductNotFoundException(
    message: String,
    productsId: List<Product>
): Exception(message)