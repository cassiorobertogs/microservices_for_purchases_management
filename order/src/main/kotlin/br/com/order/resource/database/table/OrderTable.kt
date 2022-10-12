package br.com.order.resource.database.table

import br.com.order.domain.enum.OrderStatus
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tbl_order")
data class OrderTable(
    @Id
    val id: String,
    val value: Double,
    val status: OrderStatus,
    val userId: String,
    @ManyToMany
    @JoinTable(
        name = "order_product",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")],
    )
    val products: List<ProductTable>

)