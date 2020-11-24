package com.market.domain.mapper

import com.market.domain.Category
import com.market.persistence.entity.Categoria
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mappings
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CategoryMapper {

    @Mappings(
        Mapping(source = "idCategoria", target = "id"),
        Mapping(source = "descripcion", target = "category"),
        Mapping(source = "estado", target = "active")
    )
    fun toCategory(categoria: Categoria): Category

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    fun toCategoria(category: Category): Categoria
}