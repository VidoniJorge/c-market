package com.market.domain.mapper

import com.market.domain.Product
import com.market.persistence.entity.Producto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring", uses = [
    CategoryMapper::class
])
interface ProductMapper {

    @Mappings(
            Mapping(source = "idProducto", target = "id"),
            Mapping(source = "nombre", target = "name"),
            Mapping(source = "precioVenta", target = "price"),
            Mapping(source = "cantidadStock", target = "stock"),
            Mapping(source = "estado", target = "stock"),
            Mapping(source = "categoria", target = "category"),
            Mapping(source = "idCategoria", target = ""),
    )
    fun toProduct(producto: Producto): Product
    fun toProducts(productos: List<Producto>): List<Product>

    @InheritInverseConfiguration
    fun toProducto(product: Product): Producto
}