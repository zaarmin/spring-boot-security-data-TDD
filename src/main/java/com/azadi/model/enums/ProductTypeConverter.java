package com.azadi.model.enums;

import javax.persistence.AttributeConverter;

public class ProductTypeConverter implements AttributeConverter<ProductType,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductType productType) {
        return Integer.valueOf(productType.getValue().toString());
    }

    @Override
    public ProductType convertToEntityAttribute(Integer data) {
        return ProductType.findByLabel(data.toString());
    }
}
