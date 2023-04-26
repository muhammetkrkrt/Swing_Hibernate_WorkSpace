package com.muhammet.relations;

import com.muhammet.utility.HibernateUtility;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Runner {
        private static Session session;
        private static Transaction transaction;
    public static void main(String[] args){
      session = HibernateUtility.getFACTORY().openSession();
      transaction = session.beginTransaction();
      List<Address> adresListesi = new ArrayList<>();
      Address adres = new Address();
      adres.setAd("Ev Edresim ");
      adres.setAddress("Ankara");
      adresListesi.add(adres);
      adres = new Address();
      adres.setAd("İş Edresim ");
      adres.setAddress("İstanbul");
      adresListesi.add(adres);
      
      Car car = new Car();
      car.setMarka("BMW");
      car.setModel("i8");
      car.setPlaka("06 GHTG 0054");
      
      Person person = new Person();
      person.setAge(35);
      person.setName("Muhammet");
      person.setSurname("HOCA");
      person.setPhone("0 555 999 6688");
      person.setCar(car);
      person.setAdreslist(adresListesi);
      session.save(person);
      transaction.commit();
      session.close();
    }
}
