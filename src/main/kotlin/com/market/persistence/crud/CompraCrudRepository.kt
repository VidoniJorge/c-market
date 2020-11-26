package com.market.persistence.crud

import com.market.persistence.entity.Compra
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CompraCrudRepository : CrudRepository<Compra, Int> {
    fun findByIdCompra(idCompra: Int): Optional<List<Compra>>
}