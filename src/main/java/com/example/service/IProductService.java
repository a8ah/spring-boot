package com.example.service;
import java.util.List;

import com.example.dto.CreateProductDto;
import com.example.entity.Product;

public interface IProductService {

    public List<Product> findAll();

	public Product findProductById(Integer id);

	public Product saveProduct(CreateProductDto createProductDto);

	public String deleteProduct(Integer id);

	public String updateProduct(CreateProductDto createProductDto, int id);
    
}
