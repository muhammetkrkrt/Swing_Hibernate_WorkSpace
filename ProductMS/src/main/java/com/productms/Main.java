package com.productms;

import com.productms.app.Menu;
import com.productms.util.HibernateUtility;

public class Main {

    public static void main(String[] args) {

        //HibernateUtility.getSessionFactory().openSession();

        Menu menu = new Menu();
        menu.menu();
    }


}