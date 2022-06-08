package com.azadi.service.api;

import com.azadi.model.dto.ProductGroupDto;
import com.azadi.model.entity.ProductGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ProductGroupApi {

       void  addProductGroup(ProductGroupDto productGroupDto);

       ProductGroupEntity updateProductGroup(Long productGroupId,  ProductGroupDto editProductDto) throws NoSuchElementException;

       void deleteProductGroup(Long productGroupId) throws NoSuchElementException;

       ProductGroupEntity findByCode(Long code) throws NoSuchElementException;

       List<ProductGroupEntity> findAll();

    public Page<ProductGroupEntity> findByPage(boolean active , Pageable pageable);
}
