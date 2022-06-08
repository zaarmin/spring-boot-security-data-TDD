package com.azadi.mapper;

import com.azadi.model.dto.ProductGroupDto;
import com.azadi.model.entity.ProductGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductGroupMapper {

    ProductGroupMapper MAPPER = Mappers.getMapper( ProductGroupMapper.class );

    @Mappings({
            @Mapping(source = "entity.code" ,target = "productGroupCode"),
            @Mapping(source = "entity.name" ,target = "productGroupName")
    })
    ProductGroupDto toDto(ProductGroupEntity entity );

    @Mappings({
            @Mapping(source = "dto.productGroupCode" ,target = "code"),
            @Mapping(source = "dto.productGroupName" ,target = "name")
    })
    ProductGroupEntity toEntity(ProductGroupDto dto );

    List<ProductGroupDto> EntitiesToDtos(List<ProductGroupEntity> productGroupEntities);
}
