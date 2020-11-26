package com.market.domain

import java.time.LocalDateTime

class Purchese(
        var id: Int,
        var clientId: String,
        var date: LocalDateTime,
        var paymentmethod: String,
        var comment: String,
        var state: String,
        var items: List<PurcheseItem>?
) {
    constructor():this(0,"",LocalDateTime.now(),"","","",null)
}