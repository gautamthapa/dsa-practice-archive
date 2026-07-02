package com.gautamthapa.javapractice.misc;

public class MainMethodRND {

    // compiled successfully without public method won't load
    // at run time error (Caused by: java.lang.NoClassDefFoundError: com/gautamthapa/javapractice/misc/MainMethodRND) 
    //  static void main(String[] args) {
    //     System.out.println("gtm");
    // }
    
    // compiled successfully without static method won't load 
    // at run time error (Caused by: java.lang.NoClassDefFoundError: com/gautamthapa/javapractice/misc/MainMethodRND) 
    // public void main(String[] args) {
        
    // }
    
    // compiled successfully without static method won't load 
    // at run time error (Caused by: java.lang.NoClassDefFoundError: com/gautamthapa/javapractice/misc/MainMethodRND) 
    // public static int main(String[] args) {
    //     System.out.println("test");
    //     return 0;
    // }
    
    // if same method defined in a class duplicate then it gives compile time error
    // public static void main(String[] args) {
    //     System.out.println("test");
    // }
    // public static void main(String[] args) {
    //     System.out.println("test");
    // }

    
}
