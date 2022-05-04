package thred.threadlocal;

/**
 * ThreadLocal 散列测试
 * @author Java男朋友
 * @date 2022-04-04 17:36
 */
public class ThreadLocalHashTest {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        int hashCode = 0;
        for (int i = 0; i < 16; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int idx = hashCode & 15;
            System.out.println("斐波那契散列：" + idx + " 普通散列：" + (String.valueOf(i).hashCode() & 15));
        }

    }

}
