package br.com.order.resource.database.repository

import br.com.order.resource.database.table.OrderTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  OrderPostgresRepository: JpaRepository<OrderTable, String> {

}