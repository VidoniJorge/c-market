package com.market.domain.service

import com.market.domain.Purchese
import com.market.domain.repository.PurchaseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PurcheseService(val repository: PurchaseRepository) {
    fun getAll(): List<Purchese> {
        return repository.getAll()
    }

    fun getByClient(idClient: Int): Optional<List<Purchese>> {
        return repository.getByClient(idClient)
    }

    fun save(purchese: Purchese): Purchese {
        return repository.save(purchese)
    }
}