package org.muhammet.repository;



import org.muhammet.entity.Information;
import org.muhammet.entity.User;
import org.muhammet.utility.HibernateUtility;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class UserRepository {
    public  EntityManager entityManager;
    public CriteriaBuilder criteriaBuilder;

    //Medium makale sitesi

    //
    //Hibernate nedir ?
    //entity manager nedir , niye kullanilir
    //Session
    //transaction
    //nativeQuery
    //criteriaQuery
    //Dinamik sorgular ve static sorgular ayrimi

    /*
           findAll methodu yazalim tum userleri listeleyelim , list donsun
     */
    public UserRepository(){
        entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }
    public List<User> findAll(){
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root);
        List<User> userList = entityManager.createQuery(userCriteriaQuery).getResultList();
        return userList;
    }

    public List<User> findAllNativeQuery(){
        String sql = "Select * from tbl_user";
        List<User> users = entityManager.createNativeQuery(sql,User.class).getResultList();
        return users;
    }

    public User findById(Long id){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"),id));
        User user = entityManager.createQuery(criteriaQuery).getSingleResult();
        return  user;
    }
    public List<Information> findAllInformation(){
        CriteriaQuery<Information> informationCriteriaQuery = criteriaBuilder.createQuery(Information.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information"));
        List<Information> informationList = entityManager.createQuery(informationCriteriaQuery).getResultList();
        return informationList;
    }

    public List<String> findAllInformationByName(){
        CriteriaQuery<String> informationCriteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<User> root = informationCriteriaQuery.from(User.class);
        informationCriteriaQuery.select(root.get("information").get("name"));
        List<String> strings = entityManager.createQuery(informationCriteriaQuery).getResultList();
        return strings;
    }

    public User findByUserName(String username){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"),username));
        User user = entityManager.createQuery(criteriaQuery).getSingleResult();
        return user;
    }

    public List<User> findSearch(String kelime){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("information").get("name"),kelime+"%"));
        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
        return users;
    }

    public List<User> findSearch2(){
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.and(
                criteriaBuilder.greaterThanOrEqualTo(root.get("postcount"),6),
                criteriaBuilder.like(root.get("information").get("name"), "a%")));
        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
        return users;
    }

    public int postCount(){
        int count;
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root);
        List<User> userList = entityManager.createQuery(userCriteriaQuery).getResultList();
        count = userList.stream().mapToInt(User::getPostcount).sum();
        return count;
    }
    public int postCount2(){
        CriteriaQuery<Integer> userCriteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(criteriaBuilder.sum(root.get("postcount")));
        return entityManager.createQuery(userCriteriaQuery).getSingleResult();
    }

    public List<Object[]> showDetails1(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        Path<String> username = root.get("username");
        Path<String> gender = root.get("eGender");
        Path<Integer> postCount = root.get("postcount");

        criteriaQuery.select(criteriaBuilder.array(username,gender,postCount));
        List<Object[]> users = entityManager.createQuery(criteriaQuery).getResultList();

        for (Object[] user : users) {
            System.out.println("username: " + user[0]);
            System.out.println("Gender: " + user[1]);
            System.out.println("postCount: " + user[2]);
            System.out.println("-----------------");
        }
        return users;
    }


    public List<Object[]> showDetails2(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.multiselect(root.get("username"),root.get("eGender"),root.get("postcount"));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

   /* public List<Object[]> showGender(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(criteriaBuilder.count());
    }*/
}
