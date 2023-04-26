package com.productms.app;

import com.productms.controller.CategoryController;
import com.productms.controller.ProductController;

import java.util.HashMap;

public class Menu {

    private CategoryController categoryController;
    private ProductController productController;

    public Menu(){
        this.categoryController = new CategoryController();
        this.productController= new ProductController();
    }

    public void menu(){

        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Admin");
        menuItems.put(2,"Customer");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                adminMenu();
                break;
        }
    }

    private void adminMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();

        while (true){
            menuItems.put(1,"Category Ekle");
            menuItems.put(2,"Product Ekle");
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1 :
                    categoryController.save();
                    break;
                case 2:
                    productController.save();
                    break;
            }
        }
    }
}
