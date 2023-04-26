package com.productms.service;

import com.productms.entity.Category;
import com.productms.repository.CategoryRepository;
import com.productms.util.MyFactoryRepository;
import com.productms.util.MyFactoryService;

public class CategoryServise extends MyFactoryService <CategoryRepository, Category,Long> {
    public CategoryServise() {
        super(new CategoryRepository());
    }
}
