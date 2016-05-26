package kr.ac.jejunu.model;

import javax.persistence.*;

/**
 * Created by hyh0408 on 2016. 5. 26..
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    @JoinColumn(name = "userinfo_id")
    @ManyToOne
    private User user;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
