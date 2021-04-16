package kr.ac.jejunu;

public class Singleton {
    private static Singleton singleton;

    public static Singleton newInstance() {
        if(singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}
