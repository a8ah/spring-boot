package com.example.dto;

public class ProductDto {
    
    private String name;
    private String description;
    private float price;
    private String category_name;   

    public ProductDto(){}

    public ProductDto(String name, String description, float price, String category_name){

        this.name=name;
        this.description= description;
        this.price=price;
        this.category_name=category_name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
