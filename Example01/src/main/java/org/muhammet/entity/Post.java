package org.muhammet.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date date = new Date();
    private Long user_id;


    public Post( String content, Date date, Long user_id) {
        this.content = content;
        this.date = date;
        this.user_id = user_id;
    }

    public Post( String content, Long user_id) {
        this.content = content;
        this.user_id = user_id;
    }
    public Post() {

    }
}
