package com.market.persistence.crud

import com.market.persistence.entity.Producto
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProductoCrudRepository : CrudRepository<Producto, Int> {
    fun findByIdCategoria(idCategoria: Int): Producto
    fun findByCantidadStockLessThanAndEstado(cantidadStock: Int, estado: Boolean): Optional<List<Producto>>
}