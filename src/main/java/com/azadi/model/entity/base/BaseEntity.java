package com.azadi.model.entity.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    @Version
    @Column(name = "VERSION")
    protected Integer version;

}
