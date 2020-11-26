package com.market.domain.mapper

import com.market.domain.Purchese
import com.market.persistence.entity.Compra
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = [PurcheseItemMapper::class])
@Component
interface PurcheseMapper {

    @Mappings(
            Mapping(source = "idCompra", target = "id"),
            Mapping(source = "idCliente", target = "clientId"),
            Mapping(source = "fecha", target = "date"),
            Mapping(source = "medioPago", target = "paymentmethod"),
            Mapping(source = "comentario", target = "comment"),
            Mapping(source = "estado", target = "state"),
            Mapping(source = "productos", target = "items"),
    )
    fun toPurcharse(compra: Compra): Purchese
    fun toPurcharses(compra: List<Compra>): List<Purchese>

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    fun toCompra(purchese: Purchese): Compra
}