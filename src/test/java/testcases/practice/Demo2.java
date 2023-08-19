package testcases.practice;

import org.testng.annotations.*;

public class Demo2 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class-Demo2!!");
        int a=10, b=20;
        int c=a+b;
        System.out.println("Addition of a, b is :"+c);
        System.out.println("************************");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method-Demo2!!!");
        int x=5;
        int y =x*x*x;
        System.out.println("Cube of the given number is :"+y);
        System.out.println("************************");
    }

    @Test
    public void test1(){
        System.out.println("Test1-Demo2!!!");
        int x=5;
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
        System.out.println("************************");
    }

    @Test
    public void test2(){
        System.out.println("Test2-Demo2!!!");
        int a=10, b=20;
        int c=a-b;
        System.out.println("Subtraction of a, b is :"+c);
        System.out.println("************************");
    }

    @Test
    public void test3(){
        System.out.println("Test3-Demo2!!!");
        int a=10, b=20;
        int c=a*b;
        System.out.println("Multiplication of a, b is :"+c);
        System.out.println("************************");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method-Demo2!!!");
        System.out.println("Core Java!!!!");
        System.out.println("************************");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass-Demo2!!!");
        System.out.println("Advanced Java!!!");
        System.out.println("************************");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test-Demo2!!!");
        System.out.println("Ramya!!!");
        System.out.println("************************");
    }
}
