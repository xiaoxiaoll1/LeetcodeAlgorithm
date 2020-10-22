package clone;

import reflect.Person;

public class Base {

           public static void main(String[] args) throws CloneNotSupportedException {
               PersonClone person = new PersonClone();
                person.setName("a");
                 person.setAge(12);
               PersonClone per1=(PersonClone) person.clone();
             per1.setName("b");
                 per1.setAge(14);;
                System.out.println(person.getName()+" "+person.getAge().hashCode(0));
                 System.out.println(per1.getName()+" "+per1.getAge());
             }
         }

class PersonClone implements Cloneable{
    private String name;
     private Integer age;
     public String getName() {
                 return name;
             }
     public void setName(String name) {
                 this.name = name;
            }
     public Integer getAge() {
                 return age;
             }
     public void setAge(Integer age) {
                 this.age = age;
            }
     @Override
     protected Object clone() throws CloneNotSupportedException  {
                 return super.clone();
             }
 }