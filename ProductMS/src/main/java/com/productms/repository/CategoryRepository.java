package com.productms.repository;


import com.productms.entity.Category;
import com.productms.util.MyFactoryRepository;

public class CategoryRepository extends MyFactoryRepository<Category,Long> {
    public CategoryRepository() {
        super(new Category());
    }
}
