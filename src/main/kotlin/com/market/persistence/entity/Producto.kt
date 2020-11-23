package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "productos")
class Producto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_producto")
        val idProducto: Int,

        @Column(name = "nombre")
        val nombre: String,

        @Column(name = "id_categoria")
        val idCategoria: Int,

        @Column(name = "codigo_barras")
        val codigoBarra: String,

        @Column(name = "precio_venta")
        val precioVenta: Double,

        @Column(name = "cantidad_stock")
        val cantidadStock: Int,

        @Column(name = "estado")
        val estado: Boolean,

        @ManyToOne
        @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
        val categoria: Categoria?
) {
        constructor(): this(0, "",0,"",0.0,0,false,null)
}