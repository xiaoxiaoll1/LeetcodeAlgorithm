package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //框架底层实现
        InputStream resourceAsStream = ReflectTest.class.getClassLoader().getResourceAsStream("reflect.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        declaredMethod.invoke(o);
    }
}
