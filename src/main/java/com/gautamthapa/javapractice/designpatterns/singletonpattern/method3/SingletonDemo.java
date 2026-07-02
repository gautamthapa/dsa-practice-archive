package com.gautamthapa.javapractice.designpatterns.singletonpattern.method3;

// Instance Creation using synchronized
public class SingletonDemo {
    public static void main(String[] args) {
        // here create single thread single object
//        Abc Obj1= Abc.getInstance();
//        Abc Obj2= Abc.getInstance();

        // this below threads create 2 objects
        Thread t1=new Thread(() -> {
            Abc Obj1= Abc.getInstance();
        });
        Thread t2=new Thread(() -> {
            Abc Obj2= Abc.getInstance();
        });
        t1.start();
        t2.start();

    }
}

class Abc{
    public static Abc obj;
    int i;
    private Abc(){
        System.out.println("Instance Created!!!");
    }
    public static synchronized Abc getInstance(){
        if (obj==null){
            obj=new Abc();
        }
        return obj;
    }

}