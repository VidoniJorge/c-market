package com.market.domain.mapper

import com.market.domain.PurcheseItem
import com.market.persistence.entity.ComprasProducto
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = [ProductMapper::class])
@Component
interface PurcheseItemMapper {

    @Mappings(
            Mapping(source = "comprasProducto.idProducto", target = "productId"),
            Mapping(source = "cantidad", target = "quantity"),
            Mapping(source = "estado", target = "active"),
    )
    fun toPurchaseItem(producto: ComprasProducto): PurcheseItem

    @InheritInverseConfiguration
    @Mappings(
            Mapping(target = "compra", ignore = true),
            Mapping(target = "comprasProducto.idCompra", ignore = true),
            Mapping(target = "producto", ignore = true),
    )
    fun toComprasProducto(purcheseItem: PurcheseItem): ComprasProducto
}