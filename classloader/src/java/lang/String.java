package java.lang;

/**
 * @author xieweidu
 * @createDate 2020-02-23 17:50
 */
public class String {

    // 类的初始化第三个阶段——初始化阶段 <clinit>
    static {
        System.out.println("我是自定义的String类的静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("测试");
    }

}
