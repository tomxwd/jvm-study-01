package top.tomxwd.initialization;

/**
 * @author xieweidu
 * @createDate 2020-02-23 16:25
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        // 获取系统类加载器【AppClassLoader】
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(systemClassLoader);

        // 获取其上层：扩展类加载器【ExtClassLoader】
        ClassLoader extClassLoader = systemClassLoader.getParent();
        // sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println(extClassLoader);

        // 获取其上上层：获取不到引导类加载器【null】
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        // null
        System.out.println(bootstrapClassLoader);

        // 对于用户自定义类来说，获取其类加载器【默认是使用系统类加载器】
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        // 获取String的类加载器【null】，获取不到，
        // 证明是引导类加载器进行加载的，
        // 系统的核心类库都是使用引导类加载器进行加载的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);

    }

}
