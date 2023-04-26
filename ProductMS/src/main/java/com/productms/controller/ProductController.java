package com.productms.controller;

import com.productms.app.BAUtils;
import com.productms.entity.Category;
import com.productms.entity.Product;
import com.productms.service.CategoryServise;
import com.productms.service.ProductServise;

import java.util.Optional;

public class ProductController {

    private ProductServise productServise;
    private CategoryServise categoryServise;
    public ProductController(){
        this.productServise = new ProductServise();
        this.categoryServise = new CategoryServise();
    }

    public  void save(){

        Product product = new Product();
        String name = BAUtils.readString("Product Name");
        double price = BAUtils.readDouble("Product Price");
        int stock = BAUtils.readInt("Product Stock");

        long categoryId = BAUtils.readInt("CategoryId: ");
        Optional<Category> optionalCategory =  categoryServise.findById(categoryId);
        if(optionalCategory.isPresent()){
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategory(optionalCategory.get());
            productServise.save(product);
        }else {
            System.out.println("Böyle bir kategory bulunmamaktadır");
        }
    }
}
