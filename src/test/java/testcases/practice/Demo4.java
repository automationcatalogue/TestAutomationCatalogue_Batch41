package testcases.practice;

import org.testng.annotations.*;

public class Demo4 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test!!!!-Demo4");
        System.out.println("Sarika!!!");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class-Demo4!!");
        System.out.println("************************");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method-Demo4!!!");
        System.out.println("Cube of the given number is :");
        System.out.println("************************");
    }

    @Test
    public void test1(){
        System.out.println("Test1-Demo4!!!");
        System.out.println("************************");
    }

    @Test
    public void test2(){
        System.out.println("Test2-Demo4!!!");
        System.out.println("************************");
    }

    @Test
    public void test3(){
        System.out.println("Test3-Demo4!!!");
        System.out.println("************************");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method-Demo4!!!");
        System.out.println("Core Java!!!!");
        System.out.println("************************");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass-Demo2!!!");
        System.out.println("Advanced Java!!!");
        System.out.println("************************");
    }
}
