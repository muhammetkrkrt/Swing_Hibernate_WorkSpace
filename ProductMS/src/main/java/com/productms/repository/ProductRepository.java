package com.productms.repository;

import com.productms.entity.Product;
import com.productms.util.MyFactoryRepository;

public class ProductRepository extends MyFactoryRepository<Product,Long> {
    public ProductRepository() {
        super(new Product());
    }
}
