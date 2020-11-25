package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "compras_productos")
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
        var compra: Compra?,

        @ManyToOne
        @JoinColumn(name = "id_producto", insertable = false, updatable = false)
        var producto: Producto?
) {
    constructor() : this(ComprasProductoPK(0, 0), 0, 0.0, false, null, null)
}