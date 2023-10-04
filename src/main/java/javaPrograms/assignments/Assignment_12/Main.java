package javaPrograms.assignments.Assignment_12;

public class Main extends Employee{
    void display(char c){
        super.display(c);
        System.out.println("Another employee name");
        new Employee().display('D');
        display(7);
    }
    String display(int c){
        System.out.println("His expeirence "+c);
        return "Bye";
    }

    public static void main(String[] args) {
        Employee e = new Main();
        e.display('S');
    }
}
