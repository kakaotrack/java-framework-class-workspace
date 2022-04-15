package kr.ac.jejunu;

import org.junit.jupiter.api.Test;

public class LombokTests {
    @Test
    public void test() {
        User user1 = User.builder().id(1).name("hulk").password("1234").build();
        User user2 = new User();
        user1.setId(1);
        user1.setName("hulk");
        user1.setPassword("1234");
        user2.setId(1);
        user2.setName("hulk");
        user2.setPassword("1234");
        System.out.println(user1);
        System.out.println(user2);
        String a= new String("1");
        String b= new String("1");
        System.out.println(user1.equals(user2));
    }
}
