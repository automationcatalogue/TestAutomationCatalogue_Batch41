package javaPrograms.oops.Constructors;

public class Demo2 {

    public static void main(String[] args) {
        Emp2 ob1 = new Emp2(101, 50000.00f);
        Emp2 ob2 = new Emp2(102, 60000.00f);
        Emp2 ob3 = new Emp2(103, 70000.00f);

        System.out.println(ob1.empNo+"-"+ob1.empSalary);
        System.out.println(ob2.empNo+"-"+ob2.empSalary);
        System.out.println(ob3.empNo+"-"+ob3.empSalary);
    }
}
