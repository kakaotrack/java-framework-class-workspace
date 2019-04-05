package kr.ac.jejunu.userdao;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
}
