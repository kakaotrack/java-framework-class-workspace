package kr.ac.jeju.user2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class User2Application {

    public static void main(String[] args) {
        SpringApplication.run(User2Application.class, args);
    }

}
