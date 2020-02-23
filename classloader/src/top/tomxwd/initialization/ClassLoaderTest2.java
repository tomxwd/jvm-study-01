package top.tomxwd.initialization;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @author xieweidu
 * @createDate 2020-02-23 16:57
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        System.out.println("---------------启动类加载器加载路径---------------");
        // 虽然获取不到启动类加载器对象，但是可以知道他加载的路径有哪些，也就是负责加载哪些路径下的类
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }
        // 从上面的路径中随便选择一个类，看看他的类加载器是什么，是null，是引导类加载器
        System.out.println(Provider.class.getClassLoader());



        System.out.println("---------------扩展类加载器---------------");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        // 从上面的路径中随便选择一个类，看看他的类加载器是什么，是ExtClassLoader，扩展类加载器
        System.out.println(CurveDB.class.getClassLoader());


        System.out.println("---------------系统类加载器---------------");
    }

}
