package com.azadi.model.dto;

import lombok.Data;

@Data
public class ProductGroupDto {

    private Long id;
    private Long productGroupCode;
    private String productGroupName;
    private boolean active;

    //private List<ProductDto> productDtoList;
}
