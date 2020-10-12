package Model.singleton;

/**
 * 静态内部类写法
 */
public class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }
}
