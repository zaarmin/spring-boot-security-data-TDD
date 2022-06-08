package com.azadi.repository;

import com.azadi.model.entity.ProductGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductGroupRepository  extends JpaRepository<ProductGroupEntity,Long> {

    Optional<ProductGroupEntity> findByCode(Long code) ;

    Page<ProductGroupEntity> findByActive(boolean acrive, Pageable pageable);
}
