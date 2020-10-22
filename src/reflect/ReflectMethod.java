package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectMethod {

    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        System.out.println(personClass.getName());
        Method see = personClass.getDeclaredMethod("see", String.class);
        see.setAccessible(true);
        Person person = new Person();
        Object d = see.invoke(person, "dfsfsd");
        System.out.println(d);

    }
}
