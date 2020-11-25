package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "productos")
class Producto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_producto")
        var idProducto: Int?,

        @Column(name = "nombre")
        var nombre: String,

        @Column(name = "id_categoria")
        var idCategoria: Int,

        @Column(name = "codigo_barras")
        var codigoBarra: String,

        @Column(name = "precio_venta")
        var precioVenta: Double,

        @Column(name = "cantidad_stock")
        var cantidadStock: Int,

        @Column(name = "estado")
        var estado: Boolean,

        @ManyToOne
        @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
        var categoria: Categoria?
) {
        constructor(): this(0, "",0,"",0.0,0,false,null)
}