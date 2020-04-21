package com.pad.mysql.demo.repo;

import com.pad.mysql.demo.data.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}