package com.azadi.domain;

import com.azadi.model.entity.ProductGroupEntity;
import org.junit.jupiter.api.Test;

public class ProductGroupTest {

    @Test
    public void createProductGroup(){

        ProductGroupEntity productGroupEntity=new ProductGroupEntity();
        productGroupEntity.setCode(1L);
        productGroupEntity.setName("Fridge");
        productGroupEntity.setActive(true);

    }
}
