package com.muhammet.repository;

import com.muhammet.repository.entity.Urun;
import com.muhammet.repository.view.VwUrun;
import com.muhammet.utility.HibernateUtility;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UrunRepository {

    /**
     * Tüm DB işlemleri  burada yapılmalı ve sadece kendine ait service' e 
     * hizmet etmelidir. 
     */
    // create,update,delete
    private Session session;
    private Transaction transaction;
    // sorgulma 
    private static EntityManager entityManager;
    private static CriteriaBuilder criteriaBuilder;
    
    
    private void tempData(){
    
        session = HibernateUtility.getFACTORY().openSession();
        transaction = session.beginTransaction();
        
        Urun urun;
        urun = new Urun(null, "AMD Ryzen 7 7700X 4.5 GHz 8 Çekirdek 40MB Cache AM5 Soket 5nm İşlemci", 
                "AMD Ryzen", "7700x", 8689d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Amd Ryzen 5 5500 3.6 GHz 6 Çekirdek 16MB Cache Am4 Soket 7nm İşlemci", 
                "AMD Ryzen", "5500", 2299d, 1, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Intel Core i9 13900K 3.00GHz 24 Çekirdek 36MB Önbellek LGA1700 Soket",
                "Intel", "i9 13900K", 14799d, 10, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Zotac RTX 3060 Twin Edge 12 GB GDDR6 192 Bit DP/HDMI Pci-E 4.0 Ekran Kartı",
                "Zotac", "RTX 3060", 7698d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Zotac Geforce Rtx 4090 Gamıng Trınıty ZT-D40900D-10P 24GB GDDR6X 384 Bit Ekran Kartı",
                "Zotac", "Rtx 4090", 39998d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "G.Skill Trident Z5 Gümüş Ddr5 6000MHZ CL36 32GB (2X16GB) "
                 , "G.Skill", "Trident Z5 Gümüş Ddr5", 26500d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "G.Skill 8GB 3200mhz Ram", "G.Skill", "F4-3200C16S-8GVKB", 554d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "MSI PRO Z790-P WIFI DDR4 SOKET 1700 DDR4 5333MHZ(OC) PCI-E Gen4 M.2 USB3.2 DP HDMI 1x2.5G LAN  WI-FI 6E ATX",
                "MSI", " PRO Z790-P WIFI DDR4", 6299d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        urun = new Urun(null, "Seagate BarraCuda 2TB 7200RPM 256MB Sabit Disk ST2000DM008",
                "Seagate", "BarraCuda 2TB",1099d, 120, "", 1681732555000L,1681732555000L, 1);
        session.save(urun);
        transaction.commit();
        session.close();
    
    }
   
    
    public static void main(String[] args){
      //  UrunRepository repo = new UrunRepository();
      //  repo.tempData();
      /**
       * ORM araçları tablo ile java sınıflarını eşleştirirç. bu nedenle 
       * tüm işlemler bu entity ler üzerinden yürür. Bu nedenle entityleri
       * yönetecek ve onları her anlamda okuyabilecek bir sınıfa ihtiyaç vardır
       * 
       * Bu EntityManager nesnesidir. ancak tek başına yeterli gelmez, çünkü
       * sorguların oluşturulması ve entity manager üzerinden eşleitirşlmesi de
       * gereklidir. bu nedenle Criteria nesnesine ihtiyaç vardır. criteria
       * nesnesini yönetmek içinde CriteriaBuilder kullanalım.
       */
      /**
       * SQL sorguları hibernate üzerinde de yapılabilir ancak bunu yaparken bazı
       * farklılıklar bulunmaktadır. Hibernate 3 farklı SQL şeklini destekler;
       * Native SQL -> select * from tblrun
       * JPQL       -> select u from Urun u (Burada tablo adı yerine entity adı yazılır)
       * HQL        -> from Urun
       * 
       * SQL        -> select ad,fiyat from tblurun
       * JPQL       -> select u.ad,u.fiyat from Urun u
       * HQL        -> select u.ad,u.fiyat from Urun u
       * 
       */
      entityManager = HibernateUtility.getFACTORY().createEntityManager();
      criteriaBuilder = entityManager.getCriteriaBuilder();    
      //findAll();
      //selectOneColumn();
      //selectManyColumn();
      //selectTuple();
      //usingWhereRoot();
      //usingWhereMultiple();
      //usingNativeQuery();
        usingParameter("marka", "%a%");
    }
    
    public static void findAll(){
        // select * from tblurun 
        /**
         * Hangi tablo üzerinde çalışacağımızı entity sınıfı ile belirtiyoruz.
         */
        CriteriaQuery<Urun> criteria = criteriaBuilder.createQuery(Urun.class);
        /**
         * Select işleminde geriye dönecek alanların atanacağı root nesnesini belirtiyoruz.
         */
        Root<Urun> root = criteria.from(Urun.class);
        /**
         * criteria ya select olarak geriye dönülecek alanları içeren root nesnesini veriyoruz.
         */
        criteria.select(root);
        /**
         * Son olarakta oluşturduğumuz kritere uygun olarak sorgunun çalıştırılmasını 
         * sağlamamız gerekiyor, bunun için criteria entityManager nesnesine query
         * olarak geçilir ve dönen değer belirtildiği gibi bir değere atanır.
         */
        List<Urun> urunListesi = entityManager.createQuery(criteria).getResultList();
        urunListesi.forEach(System.out::println);
    }
    public static void selectOneColumn(){
        /**
         * select ad from tblurun
         */
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root =criteriaQuery.from(Urun.class);
        /**
         * select * -> root => tablonuzun tamamını seçmek ve geri dönmek istiyorsanız kullanılır.
         * select ad -> root.get("ad") => sadece belli bir alanı seçmek istiyorsanız.
         */
        criteriaQuery.select(root.get("ad"));
        List<String> adList = entityManager
                .createQuery(criteriaQuery).getResultList();
        adList.forEach(System.out::println);
    }
    public static void selectManyColumn(){
        /**
         * select ad,fiyat from tblurun
         */        
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);
        Root<Urun> root = criteria.from(Urun.class);
        Path<String> adPath =  root.get("ad");
        Path<Double> fiyatPath = root.get("fiyat");
        criteria.select(criteriaBuilder.array(adPath,fiyatPath));
        List<Object[]> adFiyatListesi = entityManager.createQuery(criteria).getResultList();
        adFiyatListesi.forEach(x->{
            System.out.println("ad: "+x[0]+ "   - "+x[1]);
        });
        
    }
    public static void selectTuple(){
         CriteriaQuery<Tuple> criteria = criteriaBuilder.createQuery(Tuple.class);
         Root<Urun> root = criteria.from(Urun.class);
         Path<String> adPath = root.get("ad");
         Path<Double> fiyatPath = root.get("fiyat");
         /**
          * burada işlemekte olduğunuz bilgiler, sıra ile eklenecektir. bu nedenle
          * kullanırken bu sırada kullanılır ya da alan adları üzerinden kullanılır.
          */
         //                    index: 0, index: 1 
         criteria.multiselect(adPath,    fiyatPath);
         List<Tuple> tupleList = entityManager.createQuery(criteria).getResultList();
         tupleList.forEach(x->{
             // System.out.println("ad: "+ x.get(0)+ " - fiyat: "+ x.get(1));
             System.out.println("ad: "+ x.get(adPath)+ " - fiyat: "+ x.get(fiyatPath));
             
         });
    }
    public static void usingWhereRoot(){
        /**
         * select * from tblrun where id>4
         */
        CriteriaQuery<Urun> criteria = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteria.from(Urun.class);
        criteria.select(root);
        /**
         * Where işlemlerini sorgumuza eklemek için bellir methodlar kullanılarak
         * kısıtlamalar eklemeliyiz bunun için 2 yöntem bulunmaktadır.
         * 1- Predicates
         * 2- Restrictions
         */
        criteria.where(criteriaBuilder.greaterThan(root.get("id"), 4L));
        
        List<Urun> urunList = entityManager.createQuery(criteria).getResultList();
        urunList.forEach(System.out::println);
    }
    public static void usingWhereMultiple(){
        /**
         * select * from tblrun where id>4 and ad like '%f%' or id>=8
         */
        CriteriaQuery<Urun> criteria = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteria.from(Urun.class);
        criteria.select(root);
        /**
         * Where işlemlerini sorgumuza eklemek için bellir methodlar kullanılarak
         * kısıtlamalar eklemeliyiz bunun için 2 yöntem bulunmaktadır.
         * 1- Predicates
         * 2- Restrictions
         */
        
        Predicate predicateOne = criteriaBuilder.and(
                criteriaBuilder.greaterThan(root.get("id"), 4L),
                criteriaBuilder.like(root.get("ad"), "%f%")
        );
        Predicate predicateTwo = criteriaBuilder.greaterThanOrEqualTo(root.get("id"), 8L);        
        criteria.where(criteriaBuilder.or(predicateOne,predicateTwo));        
        List<Urun> urunList = entityManager.createQuery(criteria).getResultList();
        urunList.forEach(System.out::println);
    }
    public static void usingNativeQuery(){
      List<Object[]> listem = entityManager
              .createNativeQuery("select ad,marka from tblurun")
              .getResultList();
      listem.forEach(x->{
          System.out.println("ad..: "+ x[0]+ " - marka...: "+ x[1]);
      });
    }
    public static void usingNativeQueryTuple(){
      List<Tuple> listem = entityManager
              .createNativeQuery("select ad,marka from tblurun",Tuple.class)
              .getResultList();
      listem.forEach(x->{
          System.out.println("ad..: "+ x.get(0)+ " - marka...: "+ x.get(1));
      });
    }
    public static void usingParameter(String column, String value){
        CriteriaQuery<Urun> criteria = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteria.from(Urun.class);
        /**
         * criteria.where(criteriaBuilder.like(root.get("ad"),"%f%"));
         * criteria.where(criteriaBuilder.like(root.get(column),"%"+value+"%"));
         * 
         */ 
        ParameterExpression<String> parameter = criteriaBuilder.parameter(String.class);
        criteria.where(criteriaBuilder.like(root.get(column), parameter));
        TypedQuery<Urun> typedQuery = entityManager.createQuery(criteria);
        typedQuery.setParameter(parameter, value);
        List<Urun> urunListem = typedQuery.getResultList();
        urunListem.forEach(System.out::println);
    }
    
    
}
