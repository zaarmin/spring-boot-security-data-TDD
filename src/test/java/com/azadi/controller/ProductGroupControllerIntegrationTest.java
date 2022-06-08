package com.azadi.controller;


import com.azadi.model.dto.ProductGroupDto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductGroupControllerIntegrationTest {

    @Autowired
    private ProductGroupController productGroupController;

    @Test
    public void findAll(){
        List<ProductGroupDto> productGroupDtoList=
                productGroupController.findAll();
        Assertions.assertThat(productGroupDtoList.isEmpty());
    }

   /* https://howtodoinjava.com/spring-boot2/testing/spring-boot-2-junit-5/*/
}
