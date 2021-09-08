package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.CreateProductDto;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository repo;

    @Autowired
    CategoryServiceImpl category_service;
    
    @Override
    public List<Product> findAll() {
        return  repo.findAll();
    }

    @Override
    public Product findProductById(Integer id) {
        Optional<Product> category= repo.findById(id);       
        return category.get();
    }

    @Override
    public Product saveProduct(CreateProductDto createProductDto) {
        Category category= category_service.findCategoryById(
            createProductDto.getCategory_id());
        Product newProduct= new Product(
            createProductDto.getName(),
            createProductDto.getDescription(),
            createProductDto.getPrice(), category);
            return repo.save(newProduct);
    }

    @Override
    public String deleteProduct(Integer id) {
        String message="Product not found";
        if(repo.findById(id)!=null){
        repo.deleteById(id);
        message="Succesful deleted";
        }
        return message;
    }

    @Override
    public String updateProduct(CreateProductDto createProductDto, int id) {
        String message="Product not found";
        Product product= this.findProductById(id);
        if(product!=null){
            Category category= category_service.findCategoryById(
                createProductDto.getCategory_id());
            
                product.setName(createProductDto.getName());
                product.setDescription(createProductDto.getDescription());
                product.setPrice(createProductDto.getPrice());
                product.setCategory(category);;
                repo.save(product);               
        message="Succesful updated";
        }
        return message;
    }
    
}
