package com.gautamthapa.coding;

public class LamdaExpression {
    static void main() {
        Demo demo = (a, b) -> a + b;

        System.out.println("demo Sum : " + demo.sum(5, 4));
    }

}

@FunctionalInterface
interface Demo {
    int sum(int a, int b);
}
