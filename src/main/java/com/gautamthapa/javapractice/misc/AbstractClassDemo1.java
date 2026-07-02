package com.gautamthapa.javapractice.misc;

abstract class AbstractClass {
    abstract void print();
    public AbstractClass() {// Constructors can be defined in abstract classes, although they cannot be initialized, they can still be inherited by subclasses
        System.out.println("abstract class constructor");
    }
    public static void aFunc() {
        System.out.println("i am static func");
    }
}
public class AbstractClassDemo1 extends AbstractClass{
    public AbstractClassDemo1() {
        // TODO Auto-generated constructor stub
        System.out.println("Subclass Constructor");
    }
    @Override
    void print() {
        // TODO Auto-generated method stub
        System.out.println("test");
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractClassDemo1.aFunc();//Static methods can be defined in abstract classes, which can be called directly by the class name
        //Or abstractClass.aFunc();
        new AbstractClassDemo1().print();
    }
}