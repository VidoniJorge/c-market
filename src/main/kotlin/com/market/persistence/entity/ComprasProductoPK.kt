package com.market.persistence.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ComprasProductoPK(
        @Column(name = "id_compra")
        var idCompra: Int,
        @Column(name = "id_producto")
        var idProducto: Int) : Serializable {
    constructor() : this(0, 0)
}