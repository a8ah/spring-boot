package com.example.dto;

import javax.validation.constraints.NotEmpty;

public class CreateCategoryDto {

    @NotEmpty
    private String name;

    public CreateCategoryDto(){};

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
