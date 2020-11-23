package com.market.persistence.entity

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class ComprasProducto(
        @EmbeddedId
        val comprasProducto: ComprasProductoPK,

        @Column(name = "cantidad")
        val cantidad: Int,

        @Column(name = "total")
        val total: Double,

        @Column(name = "estado")
        val estado: Boolean,

        @ManyToOne
        @JoinColumn(name = "id_compra", insertable = false, updatable = false)
        val compra: Compra?,

        @ManyToOne
        @JoinColumn(name = "id_producto", insertable = false, updatable = false)
        val producto: Producto?
) {
    constructor() : this(ComprasProductoPK(0, 0), 0, 0.0, false, null, null)
}