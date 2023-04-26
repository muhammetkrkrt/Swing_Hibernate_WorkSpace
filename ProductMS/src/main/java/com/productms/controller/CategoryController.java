package com.productms.controller;

import com.productms.app.BAUtils;
import com.productms.entity.Category;
import com.productms.service.CategoryServise;

public class CategoryController {

    CategoryServise servise;
    public CategoryController(){
        this.servise = new CategoryServise();
    }

    public  void save(){
       String categoryName = BAUtils.readString("Category Name: ");
        Category category = new Category();
        category.setName(categoryName);
        servise.save(category);
    }
}
