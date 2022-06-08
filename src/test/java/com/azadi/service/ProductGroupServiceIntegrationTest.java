package com.azadi.service;


import com.azadi.model.dto.ProductGroupDto;
import com.azadi.service.api.ProductGroupApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductGroupServiceIntegrationTest {

    @Autowired
    private ProductGroupApi productGroupApi;

    @Test
    public void createProductGroup(){

        /*ProductGroupDto dto=new ProductGroupDto();
        dto.setActive(true);
        dto.setProductGroupCode(22L);
        dto.setProductGroupName("test22");
         productGroupApi.addProductGroup(dto);
         assertThat(productGroupApi.findByCode(22L).getName(),dto.getProductGroupName());*/

    }

    @Test
    public void updateProductGroup(){

    }

    @Test
    public void deleteProductGroup(){

    }

    @Test
    public void loadAll(){

    }

    @Test
    public void loadByCode(){

    }


}
