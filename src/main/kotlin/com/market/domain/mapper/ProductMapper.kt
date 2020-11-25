package com.market.domain.mapper

import com.market.domain.Product
import com.market.persistence.entity.Producto
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE
        , uses = [
    CategoryMapper::class
])
interface ProductMapper {

    @Mappings(
            Mapping(source = "idProducto", target = "id"),
            Mapping(source = "nombre", target = "name"),
            Mapping(source = "precioVenta", target = "price"),
            Mapping(source = "cantidadStock", target = "stock"),
            Mapping(source = "estado", target = "active"),
            Mapping(source = "categoria", target = "category"),
            Mapping(source = "idCategoria", target = "categoryId"),
    )
    fun toProduct(producto: Producto): Product
    fun toProducts(productos: List<Producto>): List<Product>

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarra", ignore = true)
    fun toProducto(product: Product): Producto
}