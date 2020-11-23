package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "clientes")
data class Cliente(
        @Id
        @Column(name = "id")
        val id: String,

        @Column(name = "nombre")
        val nombre: String,

        @Column(name = "apellidos")
        val apellido: String,

        @Column(name = "celular")
        val celular: Int,

        @Column(name = "direccion")
        val direccion: String,

        @Column(name = "correo_electronico")
        val correoElectronico: String,

        @OneToMany(mappedBy = "client")
        val compras: List<Compra>?
) {
    constructor() : this("", "", "", 0, "", "", null)

}