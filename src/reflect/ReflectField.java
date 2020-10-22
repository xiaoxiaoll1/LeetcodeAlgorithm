package reflect;

import java.lang.reflect.Field;

public class ReflectField {

    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Field a = personClass.getField("a");
        System.out.println(a.get(new Person()));
        Person person = new Person();
        a.set(person,"fdsfds");
        System.out.println(person.a);
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(person));

    }
}
