package com.azadi.service.impl;

import com.azadi.exception.RecordNotFoundException;
import com.azadi.model.dto.ProductGroupDto;
import com.azadi.model.entity.ProductGroupEntity;
import com.azadi.repository.ProductGroupRepository;
import com.azadi.service.api.ProductGroupApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductGroupService implements ProductGroupApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductGroupService.class);

    @Autowired
    private ProductGroupRepository repository;

    @Override
    public void addProductGroup(ProductGroupDto productGroupDto ) {
        LOGGER.info("Create ProductGroup for  code {} , name {} ", productGroupDto.getProductGroupCode(), productGroupDto.getProductGroupName());
        ProductGroupEntity entity=new ProductGroupEntity();

        entity.setCode(productGroupDto.getProductGroupCode());
        entity.setName(productGroupDto.getProductGroupName());
        entity.setActive(productGroupDto.isActive());
        //entity.setId(productGroupDto.getId());
        repository.save(entity);
    }

    @Override
    public ProductGroupEntity updateProductGroup(Long productGroupId, ProductGroupDto editProductDto) throws NoSuchElementException {
        LOGGER.info("update  ProductGroup for  code {} , name {}    ", editProductDto.getProductGroupCode(), editProductDto.getProductGroupName());
        ProductGroupEntity entity=checkProductGroup(productGroupId);
        entity.setCode(editProductDto.getProductGroupCode());
        entity.setName(editProductDto.getProductGroupName());
        entity.setActive(editProductDto.isActive());
        repository.save(entity);
        return  entity;
    }

    @Override
    public void deleteProductGroup(Long productGroupId) throws NoSuchElementException{
        LOGGER.info("Delete ProductGroup for productGroupId {}", productGroupId);
        ProductGroupEntity entity=checkProductGroup(productGroupId);
        repository.delete(entity);
    }

    @Override
    public ProductGroupEntity findByCode(Long code) throws NoSuchElementException {
        LOGGER.info("Lookup ProductGroupEntity for code {}", code);
        return repository.findByCode(code).
                orElseThrow(()->new RecordNotFoundException("Product group with code "+ code.toString()));
    }

    @Override
    @Transactional
    public List<ProductGroupEntity> findAll() {
        LOGGER.info("Lookup all ProductGroupEntity");
        return repository.findAll();
    }

    @Override
    public Page<ProductGroupEntity> findByPage(boolean active , Pageable pageable) {
        LOGGER.info("Lookup ProductGroupEntity for active {}", active);
        return repository.findByActive(active,pageable);
    }

    private ProductGroupEntity checkProductGroup(Long productGroupId)throws NoSuchElementException{
        return repository.findById(productGroupId).
                orElseThrow( ()-> new NoSuchElementException(" Product Group :"+productGroupId ));
    }
}
