package com.productms.service;

import com.productms.entity.Product;
import com.productms.repository.ProductRepository;
import com.productms.util.MyFactoryService;

public class ProductServise extends MyFactoryService<ProductRepository, Product,Long> {
    public ProductServise() {
        super(new ProductRepository());
    }
}
