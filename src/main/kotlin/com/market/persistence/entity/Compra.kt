package com.market.persistence.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "compras")
data class Compra(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_compra")
        var idCompra: Int,

        @Column(name = "id_cliente")
        var idCliente: Int,

        @Column(name = "fecha")
        var fecha: LocalDateTime,

        @Column(name = "medio_pago")
        var medioPago: String,

        @Column(name = "comentario")
        var comentario: String,

        @Column(name = "estado")
        var estado: String,

        @ManyToOne
        @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
        var cliente: Cliente?,

        @OneToMany(mappedBy = "compra", cascade = [CascadeType.ALL])
        var productos: List<ComprasProducto>?
) {
    constructor() : this(0, 0, LocalDateTime.now(), "", "", "", null, null)
}