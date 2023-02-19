package com.malchev.hillel.homework19.repository;

import com.malchev.hillel.homework19.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    @Override
    List<Product> findAll();
}
