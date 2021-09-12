package com.example.dto;

import javax.validation.constraints.NotEmpty;

public class CreateRoleDto {
    
    @NotEmpty
    private String name;

    public CreateRoleDto(){}
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
