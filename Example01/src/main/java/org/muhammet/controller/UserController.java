package org.muhammet.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.muhammet.entity.*;
import org.muhammet.repository.UserRepository;
import org.muhammet.utility.HibernateUtility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    private static Session session;
    private static Transaction transaction;

    public static void createUser(){
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<String> list1 = Arrays.asList("Book", "Comics");
        List<String> list2 = Arrays.asList("Sport", "walking");
        List<String> list3 = Arrays.asList("film", "cinema");

        Map<AdressType, Adress> adres1 = new HashMap<>();
        adres1.put(AdressType.Home, new Adress("Ankara", "Turkiye", "ayrancı"));

        Map<AdressType, Adress> adres2 = new HashMap<>();
        adres2.put(AdressType.Bussiness,new Adress("Paris", "Fransa", "XXX"));

        Map<AdressType, Adress> adres3 = new HashMap<>();
        adres3.put(AdressType.Home, new Adress("Berlin", "Almanya", "YYY"));


        Information information = new Information("ali", "kaya", "yaz");
        User user = new User("ali", "1234", information, EGender.Man, list1, adres1,4);


        Information information2 = new Information("mehmet", "kış", "son");
        User user2 = new User("osman", "1234", information2, EGender.Woman, list2, adres2,12);

        Information information3 = new Information("aslı", "güçlü", "yaz");
        User user3 = new User("aslı123", "1234", information3, EGender.Man, list3, adres3,10);

        Information information5 = new Information("zewynep", "zayıf", "zey");
        User user4 = new User("zeyn123", "456", information3, EGender.Woman, list3, adres3,6);

        Information information6 = new Information("buekt", "kuş", "bkt");
        User user5 = new User("buket123", "778899", information3, EGender.Woman, list3, adres3,6);


        session.save(user);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        transaction.commit();
        session.close();
    }
    public static void main(String[] args) {

         //createUser();
       UserRepository userRepository = new UserRepository();

        //userRepository.findAllInformation().forEach(System.out::println);
       // userRepository.findAllInformationByName().forEach(System.out::println);
        userRepository.findSearch2().forEach(System.out::println);

    }
}
