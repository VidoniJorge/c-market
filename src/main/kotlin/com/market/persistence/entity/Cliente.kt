package com.market.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "clientes")
data class Cliente(
        @Id
        @Column(name = "id")
        var id: String,

        @Column(name = "nombre")
        var nombre: String,

        @Column(name = "apellidos")
        var apellido: String,

        @Column(name = "celular")
        var celular: Int,

        @Column(name = "direccion")
        var direccion: String,

        @Column(name = "correo_electronico")
        var correoElectronico: String,

        @OneToMany(mappedBy = "cliente")
        var compras: List<Compra>?
) {
    constructor() : this("", "", "", 0, "", "", null)

}