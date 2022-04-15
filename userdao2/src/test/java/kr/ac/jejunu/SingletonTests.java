package kr.ac.jejunu;

public class SingletonTests {
    private static SingletonTests singletonTests;
    public static SingletonTests newInstance() {
        if(singletonTests == null)
            singletonTests = new SingletonTests();
        return singletonTests;
    }
}
