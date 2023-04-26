package org.muhammet.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(length = 32, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Embedded
    private Information information;

    @ElementCollection
    private List<String> interests;

    @ElementCollection
    private Map<AdressType, Adress> adress;

    private int postcount ;


    public User(String username, String password, Information information,EGender gender,List<String> interests,Map<AdressType,Adress> adress ,int postcount) {
        this.username = username;
        this.password = password;
        this.information = information;
        this.gender = gender;
        this.interests = interests;
        this.adress=adress;
        this.postcount = postcount;
    }

    public User(String username, String password, Information information,EGender gender,List<String> interests,Map<AdressType,Adress> adress) {
        this.username = username;
        this.password = password;
        this.information = information;
        this.gender = gender;
        this.interests = interests;
        this.adress=adress;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public int getPostcount() {
        return postcount;
    }

    public void setPostcount(int postcount) {
        this.postcount = postcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", information=" + information +
                ", interests=" + interests +
                ", adress=" + adress +
                '}';
    }
}
