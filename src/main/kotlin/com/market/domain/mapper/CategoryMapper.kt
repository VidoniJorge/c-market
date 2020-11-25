package com.market.domain.mapper

import com.market.domain.Category
import com.market.persistence.entity.Categoria
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface CategoryMapper {

    @Mappings(
        Mapping(source = "idCategoria", target = "id"),
        Mapping(source = "descripcion", target = "description"),
        Mapping(source = "estado", target = "active")
    )
    fun toCategory(categoria: Categoria): Category

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    fun toCategoria(category: Category): Categoria
}