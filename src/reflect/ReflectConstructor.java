package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectConstructor {

    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object sdf = constructor.newInstance("sdf", 3232);
        System.out.println(sdf);
        Object newInstance = personClass.newInstance();
        System.out.println(newInstance);

    }
}
