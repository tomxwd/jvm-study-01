package top.tomxwd.initialization;

/**
 * @author xieweidu
 * @createDate 2020-02-23 13:58
 */
public class Case04 {

    static class Father {
        public static int a = 1;

        static {
            a = 2;
        }
    }

    static class Son extends Father {
        public static int b = a;
    }

    public static void main(String[] args) {
        // 首先加载Father类，其次加载Son类，所以结果为2
        System.out.println(Son.b);
    }

}
