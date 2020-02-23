package top.tomxwd.initialization;

/**
 * 案例：如果一个static代码块中给i赋值a，再声明i为成员变量且赋另一个值b，
 * 这时候i的最终值为b，因为是按顺序赋值的。这里面的顺序是，
 * linking中prepare给i赋值为0，然后initialization中会按照顺序，
 * 先执行静态代码块中的赋值，i=a，然后在执行下一条i=b；
 *
 * @author xieweidu
 * @createDate 2020-02-23 13:36
 */
public class Case01 {

    static {
        i = 1;
//        System.out.println(i);
    }

    private static int i = 0;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
