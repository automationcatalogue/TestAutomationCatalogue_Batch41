package javaPrograms.oops.Encapsulation;

public class Demo1 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(-35);

        //p.age=-35;
        int z=p.getAge();
        System.out.println(z);
    }
}
