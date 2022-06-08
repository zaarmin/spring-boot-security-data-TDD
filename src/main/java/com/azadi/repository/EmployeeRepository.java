package com.azadi.repository;


import com.azadi.model.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends PagingAndSortingRepository<EmployeeEntity, Long> {
 
}