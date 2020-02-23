package top.tomxwd.initialization;

/**
 * 自定义一个类，就叫java.lang.String用于测试实验
 *
 * @author xieweidu
 * @createDate 2020-02-23 17:50
 */
public class StringTest {

    public static void main(String[] args) {
        java.lang.String s = new java.lang.String();
        Class<? extends String> aClass = s.getClass();
        System.out.println("aClass = " + aClass);
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader);
    }

}
