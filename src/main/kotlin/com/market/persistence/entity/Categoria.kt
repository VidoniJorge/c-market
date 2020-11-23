package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "categorias")
data class Categoria(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_categoria")
        val idCategoria: Int,

        @Column(name = "descripcion")
        val descripcion: String,

        @Column(name = "estado")
        val estado: Boolean,

        @OneToMany(mappedBy = "categoria")
        val productos: List<Producto>?
) {
    constructor() : this(0, "", false, null)
}