package thred.threadlocal;

/**
 * @author Java男朋友
 * @date 2022-04-05 11:52
 */
public class ThreadLocalMethodTest {

    public static ThreadLocal<Integer> balance = new ThreadLocal<>();

    public static void main(String[] args) {
        balance.set(100);
    }
}
