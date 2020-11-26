package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "compras_productos")
class ComprasProducto(
        @EmbeddedId
        var comprasProducto: ComprasProductoPK,

        @Column(name = "cantidad")
        var cantidad: Int,

        @Column(name = "total")
        var total: Double,

        @Column(name = "estado")
        var estado: Boolean,

        @ManyToOne
        @MapsId("idCompra")
        @JoinColumn(name = "id_compra", insertable = false, updatable = false)
        var compra: Compra?,

        @ManyToOne
        @JoinColumn(name = "id_producto", insertable = false, updatable = false)
        var producto: Producto?
) {
    constructor() : this(ComprasProductoPK(0, 0), 0, 0.0, false, null, null)
}