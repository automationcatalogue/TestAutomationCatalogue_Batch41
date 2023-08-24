package testcases.practice;

import org.testng.annotations.*;

public class Demo3 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite-Demo3");
        System.out.println("AutomationCatalogue!!!");
        System.out.println("***********************");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class-Demo3!!");
        int a=10, b=20;
        int c=a/b;
        System.out.println("Division of a, b is :"+c);
        System.out.println("************************");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method-Demo3!!!");
        int x=5;
        int y =x*x;
        System.out.println("Square of the given number is :"+y);
        System.out.println("************************");
    }

    @Test
    public void test1(){
        System.out.println("Test1-Demo3!!!");
        int x=5;
        if(x>=0){
            System.out.println("Given number is Positive!!!");
        }else{
            System.out.println("Given number is Negative!!!");
        }
        System.out.println("************************");
    }

    @Test
    public void test2(){
        System.out.println("Test2-Demo3!!!");
        int a=10;
        ++a;
        System.out.println("Pre-increment of a is :"+a);
        System.out.println("************************");
    }

    @Test
    public void test3(){
        System.out.println("Test3-Demo3!!!");
        int b=20;
        b++;
        System.out.println("Post-Increment of b is :"+b);
        System.out.println("************************");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method-Demo3!!!");
        System.out.println("Python!!!!");
        System.out.println("************************");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass-Demo3!!!");
        System.out.println("JavaScript!!!");
        System.out.println("************************");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test-Demo3!!!");
        System.out.println("Anjaneyulu!!!");
        System.out.println("************************");
    }
}
