package com.azadi.repository;

import com.azadi.model.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {


    List<BookEntity> findByName(String name);

}
