package kr.ac.jejunu.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "userinfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
