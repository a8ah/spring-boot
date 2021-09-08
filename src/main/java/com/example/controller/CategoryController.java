package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.CategoryDto;
import com.example.dto.CreateCategoryDto;
import com.example.entity.Category;
import com.example.service.CategoryServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categorys")
public class CategoryController {
    
	// @Autowired
	private ModelMapper modelMapper;
    
    @Autowired
	CategoryServiceImpl category_service;

	@GetMapping
    public List<CategoryDto> getAllCategories() {
        modelMapper = new ModelMapper();
        List<Category>list_category= category_service.findAll();
        List<CategoryDto> list_categoryDto= new ArrayList<>();
        
        for (Category category : list_category) {
            CategoryDto categoryDto= modelMapper.map(category,CategoryDto.class);
            list_categoryDto.add(categoryDto);
        }

        return  list_categoryDto;
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Integer id) {
        modelMapper = new ModelMapper();
        Category category= category_service.findCategoryById(id);
        CategoryDto categoryDto= modelMapper.map(category,CategoryDto.class);
        
        return  categoryDto;
    }

	// @PostMapping(value = "/add_person",consumes = {"application/json"},produces = {"application/json"})
    // @ResponseBody
    // public ResponseEntity<Person> addItem(@RequestBody Person person, UriComponentsBuilder builder){
    //     persona_service.savePerson(person);
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setLocation(builder.path("/addItem/{id}").buildAndExpand(person.getIdPerson()).toUri());
        
    //     return new ResponseEntity<Person>(headers, HttpStatus.CREATED);
    // }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody CreateCategoryDto categoryDto,@PathVariable Integer id){
        if(category_service.findCategoryById(id)!= null){
        modelMapper = new ModelMapper();

        // convert DTO to entity
        com.example.entity.Category category= modelMapper.map(categoryDto, com.example.entity.Category.class);
        category.setId(id);

        // create_category
        String  message = category_service.updateCategory(category);
        System.out.println(message);
        } 
    
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CreateCategoryDto createCategoryDto){
    
        modelMapper = new ModelMapper();

        // convert DTO to entity
        com.example.entity.Category category= modelMapper.map(createCategoryDto, com.example.entity.Category.class);

        // create_category
        category= category_service.saveCategory(category);

        // return UserDto
        CategoryDto categoryDto= modelMapper.map(category,CategoryDto.class);
        return ResponseEntity.ok().body(categoryDto);

    }

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable Integer id) {
        String message=category_service.deleteCategory(id);
    }
}
