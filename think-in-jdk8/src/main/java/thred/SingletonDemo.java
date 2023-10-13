package thred;

/**
 * 双端检索模式下的单例模式
 *
 * new SingletonDemo() 分为三步
 * 1、分配内存
 * 2、初始化对象
 * 3、将对象的指针指向内存
 *
 * 如果不加 volatile 的话可能会造成三步顺序混乱，先执行了1、3的话，判null就会返回false，从而导致有个线程获取到null
 *
 * volatile的作用：
 * 1、禁止指令重排，通过内存屏障来实现
 * 2、保证变量的可见性，也是通过内存屏障来实现，要求变量写和读的时候都是直接去主内存去，而不是在自己的工作内存或cpu cache
 * @author yechaoa
 * @date 2023/10/13 10:05
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 构造方法");
    }

    /**
     * 双重检测机制
     *
     * @return
     */
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
