package aviator.function;

import java.util.concurrent.TimeUnit;

/**
 * synchronized (Banane.class)  锁的是Banane.class，所有获取Banane.class的都会阻塞
 * synchronized (this)  锁的是 Apple.class,使用同一个实例对象时，调用同一个方法时会阻塞,不同方法不阻塞
 * synchronized 普通方法，锁的是同一个类声明的同一个实例（不是同一个不影响）
 * synchronized 静态方法，锁的是这个类
 *
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Apple a = new Apple();
        Apple b = new Apple();
        new Thread(() -> {
            a.eat();
            a.clean();
        }, "t1").start();
        new Thread(() -> {
            b.clean();
            a.eat();
        }, "t2").start();

    }
}

class Apple {
    Banane a = new Banane();

    public Apple() {

    }

    public synchronized static void eat() {
    //     public void eat(){
        System.out.println(Thread.currentThread().getName() + "start");
        synchronized (Banane.class) {
            System.out.println(Thread.currentThread().getName() + "eat");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "eat over");
        }
    }

    public void clean(){
        System.out.println(Thread.currentThread().getName() + "clean");
    }
}

class Banane {

}
