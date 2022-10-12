package br.com.order.resource.database.table

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tbl_product")
data class ProductTable(
    @Id
    val id:String,
    @ManyToMany(mappedBy = "products")
    val orders: List<OrderTable>
)