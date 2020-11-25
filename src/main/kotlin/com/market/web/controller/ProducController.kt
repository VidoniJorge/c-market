package com.market.web.controller

import com.market.domain.Product
import com.market.domain.service.ProductService
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/products")
class ProducController(val productService: ProductService) {
    @GetMapping("")
    fun getAll(): List<Product> {
        return productService.getAll();
    }

    @GetMapping("/category/{id}")
    fun getByCategory(@PathVariable("id") id: Int): Optional<List<Product>> {
        return productService.getByCategory(id)
    }

    /*@GetMapping("/category/{categoryId}")
    fun getScarseProducts(@PathVariable("id") quantity: Int): Optional<List<Product>> {
        return productService.getScarseProducts(quantity)
    }*/

    @GetMapping("/{id}")
    fun getProduct(@PathVariable("id")id: Int): Optional<Product> {
        return productService.getProduct(id)
    }

    @PostMapping("")
    fun save(@RequestBody product: Product): Product {
        return productService.save(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        productService.delete(id)
    }
}