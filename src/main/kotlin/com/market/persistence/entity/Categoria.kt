package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "categorias")
data class Categoria(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_categoria")
        var idCategoria: Int,

        @Column(name = "description")
        var descripcion: String,

        @Column(name = "estado")
        var estado: Boolean,

        @OneToMany(mappedBy = "categoria")
        var productos: List<Producto>?
) {
    constructor() : this(0, "", false, null)
}