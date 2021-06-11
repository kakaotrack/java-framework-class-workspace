package kr.ac.jeju.user2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "userinfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String password;
    String nickname;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
            @JsonIgnoreProperties("user")
    List<Comment> comments;
}
