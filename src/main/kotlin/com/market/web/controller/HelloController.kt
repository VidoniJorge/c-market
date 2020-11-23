package com.market.web.controller

import com.market.persistence.crud.ProductoCrudRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/saludos")
class HelloController {

    @Autowired
   private lateinit var productoCrudRepository: ProductoCrudRepository

    @GetMapping("/hola")
    fun hello(): String {

        productoCrudRepository.findById(1).ifPresent { p -> println(p.nombre) }

        return "hola mundo";
    }
}

