package com.azadi.controller;

import com.azadi.mapper.ProductGroupMapper;
import com.azadi.model.entity.ProductGroupEntity;
import com.azadi.service.impl.ProductGroupService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductGroupController.class)
public class ProductGroupControllerTest {

    @MockBean
    private ProductGroupService productGroupService;

    @MockBean
    private ProductGroupMapper productGroupMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {

        ProductGroupEntity productGroupEntity = new ProductGroupEntity();
        productGroupEntity.setActive(true);
        productGroupEntity.setName("Fridge");
        productGroupEntity.setCode(5L);
        List<ProductGroupEntity> productGroups = Arrays.asList(productGroupEntity);

        Mockito.when(productGroupService.findAll()).thenReturn(productGroups);
        mockMvc.perform(get("/productGroups/getAll")).andExpect(status().isOk());
    }
}
