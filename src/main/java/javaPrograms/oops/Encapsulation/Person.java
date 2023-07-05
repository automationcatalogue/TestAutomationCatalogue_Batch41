package javaPrograms.oops.Encapsulation;

public class Person {
    private int age;

    int getAge(){
        return age;
    }

    void setAge(int ageValue){
        if(ageValue<=0){
            age=0;
        }else if(ageValue>=100){
            age=100;
        }else{
            age=ageValue;
        }

    }

}
