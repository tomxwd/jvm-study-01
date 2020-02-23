package top.tomxwd.initialization;

/**
 * 这里为了探究<clinit>是否有加锁行为，
 * 创建两个线程并行去初始化该类，
 * 看这个类的static静态代码块会被执行几次，
 * 如果只被执行了一次，说明一个类的<clinit>在多线程的情况下会同步加锁
 * @author xieweidu
 * @createDate 2020-02-23 14:09
 */
public class Case05 {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };
        new Thread(r, "线程1").start();
        new Thread(r, "线程2").start();
    }
}

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "正在初始化该类");
            while (true) {

            }
        }
    }
}
