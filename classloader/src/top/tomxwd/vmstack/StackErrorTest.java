package top.tomxwd.vmstack;

/**
 * 演示虚拟机栈中的异常StackOverflowError
 *
 * 以下程序在没有设置虚拟机参数-Xss控制栈内存大小的时候，本机运行结果为11404
 * 加上-Xss256k之后，运行结果为2473
 * @author xieweidu
 * @createDate 2020-02-26 22:59
 */
public class StackErrorTest {

    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        // 栈溢出
        main(args);
    }

}
