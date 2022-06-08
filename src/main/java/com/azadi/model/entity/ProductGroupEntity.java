package com.azadi.model.entity;

import com.azadi.model.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Product_Group")
public class ProductGroupEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CODE", nullable = false)
    private Long code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "productGroups", fetch = FetchType.LAZY)
    private List<ProductEntity> productEntities;

}
