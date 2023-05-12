package kr.ac.jejunu.user;

public class Singleton {
    private static Singleton instance;
    public static Singleton getInstance() {
        if(instance == null)
            instance = new Singleton();
        return instance;

    }
}
