package com.example.service;

import com.example.entity.Category;
import java.util.List;

public interface ICategoryService {
    
    public List<Category> findAll();

	public Category findCategoryById(Integer id);

	public Category saveCategory(Category category);

	public String deleteCategory(Integer id);

	public String updateCategory(Category category);
}
