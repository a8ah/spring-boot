package com.example.repository;

import java.util.List;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository  extends JpaRepository <Product, Integer>{
    
    List<Product> findByName(String name);

}
