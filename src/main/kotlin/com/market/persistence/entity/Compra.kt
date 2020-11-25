package com.market.persistence.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "compras")
data class Compra(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_compra")
        val idCompra: Int,

        @Column(name = "id_client")
        val idClient: Int,

        @Column(name = "fecha")
        val fecha: LocalDateTime,

        @Column(name = "medio_pago")
        val medioPago: String,

        @Column(name = "comentario")
        val comentario: String,

        @Column(name = "estado")
        val estado: String,

        @ManyToOne
        @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
        val client: Cliente?,

        @OneToMany(mappedBy = "compra")
        val productos: List<ComprasProducto>?
) {
    constructor() : this(0, 0, LocalDateTime.now(), "", "", "", null, null)
}