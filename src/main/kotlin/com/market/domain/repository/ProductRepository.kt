package com.market.domain.repository

import com.market.domain.Product
import java.util.*

interface ProductRepository {
    fun getAll(): List<Product>
    fun getByCategory(id: Int): Optional<List<Product>>
    fun getScarseProducts(quantity: Int): Optional<List<Product>>
    fun getProduct(id: Int): Optional<Product>
    fun save(product: Product): Product
    fun delete(id: Int)
}