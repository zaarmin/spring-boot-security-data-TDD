package com.azadi.controller;

import com.azadi.mapper.ProductGroupMapper;
import com.azadi.model.dto.ProductGroupDto;
import com.azadi.model.entity.ProductGroupEntity;
import com.azadi.service.impl.ProductGroupService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ProductGroupControllerTestWithRest {


    @MockBean
    ProductGroupService productGroupService;

    @MockBean
    ProductGroupMapper productGroupMapper;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void findAll() {

        ProductGroupEntity productGroupEntity = new ProductGroupEntity();
        productGroupEntity.setActive(true);
        productGroupEntity.setName("Fridge");
        productGroupEntity.setCode(5L);
        List<ProductGroupEntity> productGroups = Arrays.asList(productGroupEntity);

        Mockito.when(productGroupService.findAll()).thenReturn(productGroups);
        ResponseEntity<List<ProductGroupDto>> response = testRestTemplate.exchange("/productGroups/getAll", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductGroupDto>>() {
                });

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK) ;



    }

}
