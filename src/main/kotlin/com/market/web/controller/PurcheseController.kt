package com.market.web.controller

import com.market.domain.Purchese
import com.market.domain.service.PurcheseService
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/purcheses")
class PurcheseController(val service: PurcheseService) {
    @GetMapping("")
    fun getAll(): ResponseEntity<List<Purchese>> {
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/clients/{id}")
    fun getByClient(@PathVariable("id") idClient: Int): ResponseEntity<List<Purchese>> {
        return service.getByClient(idClient)
                .map { c -> ResponseEntity.ok(c) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("")
    fun save(@RequestBody purchese: Purchese): ResponseEntity<Purchese> {
        return ResponseEntity.ok(service.save(purchese))
    }
}