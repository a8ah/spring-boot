package com.example.exeptions;

public class CategoryNotFound extends RuntimeException {

    CategoryNotFound(Integer id){
        super("Could not find Category with " + id);
    }
}
