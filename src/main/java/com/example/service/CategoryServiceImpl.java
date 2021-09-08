package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Category;
import com.example.repository.ICategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    ICategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public String deleteCategory(Integer id) {
        String message="Product not found";
        if(repo.findById(id)!=null){
        repo.deleteById(id);
        message="Succesful deleted";
        }
        return message;

    }

    @Override
    public String updateCategory(Category category) {
        String message="Product not found";
        if(repo.findById(category.getId())!=null){
        repo.save(category);
        message="Succesful updated";
        }
        return message;
    }

    @Override
    public Category  findCategoryById( Integer id) {
        Optional<Category> category= repo.findById(id);       
        return category.get();
    }
    
}
