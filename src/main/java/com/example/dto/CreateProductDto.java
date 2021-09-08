package com.example.dto;

public class CreateProductDto {
    
    private String name;
    private String description;
    private float price;
    private int category_id;

    public CreateProductDto(){}

    public CreateProductDto(String name, String description, float price, int category_id){

        this.name=name;
        this.description= description;
        this.price=price;
        this.category_id=category_id;
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

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

}
