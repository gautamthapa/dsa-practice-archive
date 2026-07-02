package com.gautamthapa.javapractice.oops.polymorphism.overriding;

class Test{
    public static void main(String[] args) {
        System.out.println("test1");
    }
}

// if static method override then we can not method override here
// Here static method hiding parent class static method hide from child
public class MainMethodOverride extends Test{
    public static void main(String[] args) {
        MainMethodOverride m1=new MainMethodOverride();
        m1.test();

        System.out.println("test2");
    }

    // we can call main method of immediate parent class
    public void test(){
        super.main(new String[]{"abc"});
    }

}
