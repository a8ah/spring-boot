package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.CreateProductDto;
import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.service.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
	ProductServiceImpl product_service;

	@GetMapping
    public List<ProductDto> getAllProducts() {
        List<Product>list_products= product_service.findAll();
        List<ProductDto> list_productDto= new ArrayList<>();
        
        for (Product product : list_products) {
            ProductDto productDto =  new ProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getName());
            
                list_productDto.add(productDto);
        }

        return  list_productDto;
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        Product product= product_service.findProductById(id);
        ProductDto productDto =  new ProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getName());
            
        return  productDto;
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody CreateProductDto createProductDto,@PathVariable Integer id){
        // updating_product
        String  message = product_service.updateProduct(createProductDto,id);
        System.out.println(message);
    } 

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createProductDto){
        // create_product
        Product product= product_service.saveProduct(createProductDto);

        // return UserDto
        ProductDto productDto =  new ProductDto(
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory().getName());
        
            return ResponseEntity.ok().body(productDto);

    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Integer id) {
        String message=product_service.deleteProduct(id);
    }

    
}
