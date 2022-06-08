package com.azadi.model.entity;

import com.azadi.model.entity.base.BaseEntity;
import com.azadi.model.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Product")
public class ProductEntity extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CODE", nullable = false)
    private Long code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    @Column (name="PRODUCT_TYPE")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productGroup_Id", referencedColumnName = "Id", nullable = false)
    private ProductGroupEntity productGroups;
}
