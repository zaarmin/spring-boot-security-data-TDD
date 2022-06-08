package com.azadi.mapper;

import com.azadi.model.dto.ProductGroupDto;
import com.azadi.model.entity.ProductGroupEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-01T15:33:18+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class ProductGroupMapperImpl implements ProductGroupMapper {

    @Override
    public ProductGroupDto toDto(ProductGroupEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductGroupDto productGroupDto = new ProductGroupDto();

        productGroupDto.setProductGroupCode( entity.getCode() );
        productGroupDto.setProductGroupName( entity.getName() );
        productGroupDto.setId( entity.getId() );
        productGroupDto.setActive( entity.isActive() );

        return productGroupDto;
    }

    @Override
    public ProductGroupEntity toEntity(ProductGroupDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductGroupEntity productGroupEntity = new ProductGroupEntity();

        productGroupEntity.setCode( dto.getProductGroupCode() );
        productGroupEntity.setName( dto.getProductGroupName() );
        productGroupEntity.setId( dto.getId() );
        productGroupEntity.setActive( dto.isActive() );

        return productGroupEntity;
    }

    @Override
    public List<ProductGroupDto> EntitiesToDtos(List<ProductGroupEntity> productGroupEntities) {
        if ( productGroupEntities == null ) {
            return null;
        }

        List<ProductGroupDto> list = new ArrayList<ProductGroupDto>( productGroupEntities.size() );
        for ( ProductGroupEntity productGroupEntity : productGroupEntities ) {
            list.add( toDto( productGroupEntity ) );
        }

        return list;
    }
}
