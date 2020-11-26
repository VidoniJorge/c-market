package com.market.domain

import java.time.LocalDateTime

class PurcheseItem(
        var productId: Int,
        var quantity: Int,
        var total: Double,
        var active: Boolean
) {
    constructor() : this(0, 0, 0.0, false)
}