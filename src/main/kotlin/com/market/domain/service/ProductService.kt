package com.market.domain.service

import com.market.domain.Product
import com.market.domain.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val productRepository: ProductRepository) {
    fun getAll(): List<Product> {
        return productRepository.getAll();
    }

    fun getByCategory(id: Int): Optional<List<Product>> {
        return productRepository.getByCategory(id)
    }

    fun getScarseProducts(quantity: Int): Optional<List<Product>> {
        return productRepository.getScarseProducts(quantity)
    }

    fun getProduct(id: Int): Optional<Product> {
        return productRepository.getProduct(id)
    }

    fun save(product: Product): Product {
        return productRepository.save(product)
    }

    fun delete(id: Int) {
        productRepository.delete(id)
    }
}