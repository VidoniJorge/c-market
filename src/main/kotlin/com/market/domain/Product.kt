package com.market.domain

data class Product(var id: Int,
                   var name: String,
                   var categoryId: Int,
                   var price: Double,
                   var stock: Int,
                   var active: Boolean,
                   var category: Category?) {
    constructor() : this(0, "", 0,0.0, 0, false, null)
}