package com.market.domain.repository

import com.market.domain.Purchese
import java.util.*

interface PurchaseRepository {
    fun getAll(): List<Purchese>
    fun getByClient(idClient: Int): Optional<List<Purchese>>
    fun save(purchese: Purchese): Purchese
}