package javaPrograms.oops.Polymorphism_1;

public class A {
  private void show(){
      System.out.println("Core Java");
  }

    public static void main(String[] args) {
        B ob1 = new B();
        ob1.show();
    }
}
