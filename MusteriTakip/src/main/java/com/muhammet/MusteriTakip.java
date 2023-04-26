package com.muhammet;

import com.muhammet.entity.HMusteri;
import com.muhammet.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MusteriTakip {

    private static Session ss;
    private static Transaction tt;
    private static void open(){
        ss =  HibernateUtility.getFACTORY().openSession();
        tt = ss.beginTransaction();
    }
    private static void close(){  
        tt.commit();
        ss.close();
    }
    
    public static void main(String[] args) {
         save(new HMusteri("Hakan", "Ankra", "0 555", "", 1));
         update(new HMusteri(2L,"Bahar", "Ankra", "0 555 999 8887", "", 1));
        listPrint();
    }
    
    
    public static void save(HMusteri musteri){
        /**
         * 1- Hibernate bir veritabanına çalıpmak için oturum açar
         * 2- Yapılacak olan işllemleri takip etmek gerektiğinde hatalı işlemleri 
         * geriye almak üzere bir transaction oluşturur.
         */      
        open();
        ss.save(musteri);
        close();
    }
    public static void update(HMusteri musteri){        
        open();
        /**
         * Güncelleme işleminin yapılanilmesi için mutlaka entity nin geçerli bir id sinin olması 
         * gereklidir.
         */        
        ss.update(musteri);
        close();
    }
     public static void delete(Long id){        
        open();     
        HMusteri hm = new HMusteri(id,null,null,null,null,0);
        ss.delete(hm);
        close();
    }
     
    public static void listPrint(){
        open();
        Criteria cr = ss.createCriteria(HMusteri.class);
        cr.list().forEach(System.out::println);
        close();
    }
}
