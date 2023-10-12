package thred.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子类 ABA问题的测试
 * @author yechaoa
 * @date 2023/10/12 10:38
 */
public class AtomicAbaTest {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(100);

//		ABA问题
        abcTest(count);


//		ABA的解决

        // dealAba();
    }

    private static void dealAba() {
        AtomicStampedReference<Integer> cont = new AtomicStampedReference<>(100, 1);
        int stamp = cont.getStamp();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 第1次版本号"+cont.getStamp()+"\t值是"+cont.getReference());
            cont.compareAndSet(100, 101, cont.getStamp(), cont.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t 第2次版本号"+cont.getStamp()+"\t值是"+cont.getReference());
            cont.compareAndSet(101, 100, cont.getStamp(), cont.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t 第3次版本号"+cont.getStamp()+"\t值是"+cont.getReference());
        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t 第4次版本号"+stamp+"\t值是"+cont.getReference());
            cont.compareAndSet(100, 2019, stamp, cont.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"\t 第5次版本号"+cont.getStamp()+"\t值是"+cont.getReference());
        },"t2").start();
    }

    private static void abcTest(AtomicInteger count) {
        new Thread(() -> {
            count.compareAndSet(100, 101);
            System.out.println(Thread.currentThread().getName() + " ... " + count);
            count.compareAndSet(101, 100);
            System.out.println(Thread.currentThread().getName() + " ... " + count);
        },"t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.compareAndSet(100, 2019);
            System.out.println(Thread.currentThread().getName() + " ... " + count);
        },"t21").start();
    }
}
