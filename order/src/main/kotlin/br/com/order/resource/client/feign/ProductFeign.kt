package br.com.order.resource.client.feign

import br.com.order.application.dto.ProductRequestDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(value= "product", url = "localhost:8080/product")
interface ProductFeign {
    @PostMapping("/reservation")
    fun reserve(@RequestBody products: List <ProductRequestDTO>): Double

}