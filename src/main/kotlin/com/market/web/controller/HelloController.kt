package com.market

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/saludos")
class HelloController {

    @GetMapping("/hola")
    fun hello(): String {
        return "hola mundo";
    }
}

