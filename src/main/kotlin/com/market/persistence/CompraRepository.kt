package com.market.persistence

import com.market.domain.Purchese
import com.market.domain.mapper.PurcheseMapper
import com.market.domain.repository.PurchaseRepository
import com.market.persistence.crud.CompraCrudRepository
import com.market.persistence.entity.Compra
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CompraRepository(var repository: CompraCrudRepository, var mapper: PurcheseMapper) : PurchaseRepository {
    override fun getAll(): List<Purchese> {
        var ff = repository.findAll()
        return mapper.toPurcharses(repository.findAll() as List<Compra>)
    }

    override fun getByClient(idClient: Int): Optional<List<Purchese>> {
        return repository.findByIdCompra(idClient).map {
            m-> mapper.toPurcharses(m)
        }
    }

    override fun save(purchese: Purchese): Purchese {
        var compra = mapper.toCompra(purchese)
        compra.productos?.forEach { p->
            p.compra = compra
        }
        return mapper.toPurcharse(repository.save(compra))
    }
}