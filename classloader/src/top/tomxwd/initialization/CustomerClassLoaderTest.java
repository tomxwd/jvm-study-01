package top.tomxwd.initialization;

import java.io.FileNotFoundException;

/**
 * 自定义类加载器测试
 * @author xieweidu
 * @createDate 2020-02-23 17:20
 */
public class CustomerClassLoaderTest {

    public static void main(String[] args) {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader();
        try{
            Class<?> clazz = Class.forName("One", true, customerClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClasses());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

class CustomerClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            byte[] result = getClassFromCustomerPath(name);
            if(result==null){
                throw new FileNotFoundException();
            } else {
                return defineClass(name,result,0,result.length);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomerPath(String name){
        // 从自定义路径中加载指定类：细节省略
        // 用二进制流的形式读取进来即可，如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密操作
        return null;
    }

}
