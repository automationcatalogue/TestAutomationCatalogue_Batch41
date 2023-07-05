package javaPrograms.assignments.misc;

public class TriangleDemo_ClassVariable {

    static int a=20,b=10,c=20;

    public static void main(String[] args) {


        TriangleDemo_ClassVariable ob1 = new TriangleDemo_ClassVariable();

        if(TriangleDemo_ClassVariable.a==TriangleDemo_ClassVariable.b && TriangleDemo_ClassVariable.b==TriangleDemo_ClassVariable.c){
            System.out.println("Given a,b,c are Equilateral triangle");
        }else if(ob1.a==b || TriangleDemo_ClassVariable.b==c || c==ob1.a){
            System.out.println("Given a,b,c are Bilateral triangle");
            if(a==b){
                System.out.println("a&b are same for Bilteral triangle");
            }else if(b==c){
                System.out.println("b&c are same for Bilteral triangle");
            }else if(c==a){
                System.out.println("c&a are same for Bilteral triangle");
            }
        }else if(a!=b && b!=c && c!=a){
            System.out.println("Given a,b,c are Scalen triangle");
        }
    }

}
