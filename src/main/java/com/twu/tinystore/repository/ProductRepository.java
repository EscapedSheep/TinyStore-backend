package com.twu.tinystore.repository;

import com.twu.tinystore.dto.ProductDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductDto, Integer> {
    @Override
    public List<ProductDto> findAll();
}
