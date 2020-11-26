package com.market.web.controller

import com.market.domain.Product
import com.market.domain.service.ProductService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/products")
class ProducController(val productService: ProductService) {
    @ApiOperation("Get all supermarket product")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("")
    fun getAll(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/category/{id}")
    fun getByCategory(@PathVariable("id") id: Int): ResponseEntity<List<Product>> {
        return productService.getByCategory(id)
                .map { m -> ResponseEntity.ok(m) }
                .orElse(ResponseEntity.notFound().build())
    }

    /*@GetMapping("/category/{categoryId}")
    fun getScarseProducts(@PathVariable("id") quantity: Int): Optional<List<Product>> {
        return productService.getScarseProducts(quantity)
    }*/

    @ApiOperation("Search a product with an id")
    @ApiResponses(
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 200, message = "Product not found"),
    )
    @GetMapping("/{id}")
    fun getProduct(@ApiParam(value = "The id of the product", required = true, example = "7")
                   @PathVariable("id") id: Int): ResponseEntity<Product> {
        return productService.getProduct(id)
                .map { m -> ResponseEntity.ok(m) }
                .orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping("")
    fun save(@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity.created(URI.create("")).body(productService.save(product))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int): ResponseEntity<Void> {
        productService.delete(id)
        return ResponseEntity.ok().build()
    }
}