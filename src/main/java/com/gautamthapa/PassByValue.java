package com.gautamthapa;
/*
* Java is strictly pass-by-value.
* For primitive types:
a copy of actual value is passed.
*
* For objects:
a copy of reference is passed.
 * */
public class PassByValue {
    static void main() {
        int a=10;
        increment(a);
        System.out.println("Increment: "+a);


        Student s=new Student();
        s.name = "Gautam";
        changeName(s);
        System.out.println("Name: "+s.name);
        // Here The value being copied is: REFERENCE ADDRESS, NOT the actual object.
    }

    private static void changeName(Student s) {
        s.name="LXMI";
    }

    private static void increment(int a) {
        a = a+1;
    }
}

class Student{
    String name;
}

//NOTE:
/*
* Important Proof Java is NOT Pass By Reference
* Original object will NOT change.
* Why?

Because:

only copied reference variable changed
original reference still points old object
* */