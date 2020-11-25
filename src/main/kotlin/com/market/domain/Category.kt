package com.market.domain

data class Category(var id: Int,
               var description: String,
               var active: Boolean) {
    constructor(): this(0,"",false)

}