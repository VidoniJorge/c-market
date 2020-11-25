package com.market.persistence

import com.market.domain.Product
import com.market.domain.mapper.ProductMapper
import com.market.domain.repository.ProductRepository
import com.market.persistence.crud.ProductoCrudRepository
import com.market.persistence.entity.Producto
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductoRepository(val reposiroty: ProductoCrudRepository, val mapper: ProductMapper) : ProductRepository {

    override fun getAll(): List<Product> {
        return mapper.toProducts(reposiroty.findAll() as List<Producto>)
    }

    override fun getByCategory(id: Int): Optional<List<Product>> {
        return reposiroty.findByIdCategoria(id)
                .map { p -> mapper.toProducts(p) }
    }

    override fun getScarseProducts(quantity: Int): Optional<List<Product>> {
        return reposiroty.findByCantidadStockLessThanAndEstado(quantity, true)
                .map(mapper::toProducts)

    }

    override fun getProduct(id: Int): Optional<Product> {
        return reposiroty.findById(id)
                .map(mapper::toProduct)
    }

    override fun save(product: Product): Product {
        val produto = mapper.toProducto(product)
        return mapper.toProduct(reposiroty.save(mapper.toProducto(product)))
    }

    override fun delete(id: Int) {
        reposiroty.deleteById(id)
    }
}


