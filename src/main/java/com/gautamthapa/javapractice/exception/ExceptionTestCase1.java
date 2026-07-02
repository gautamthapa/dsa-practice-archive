package com.gautamthapa.javapractice.exception;

public class ExceptionTestCase1 {
    public static void main(String[] args) {
        System.out.println("Test");
       // this commented code gives compile time error
//        try{
//            int a=30/0;
//        }catch (Exception e){
//            e.printStackTrace();
//        }catch (ArithmeticException a){
//            a.printStackTrace();
//        }


        try{
            int a=30/0;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception a){
            a.printStackTrace();
        }
    }
}
