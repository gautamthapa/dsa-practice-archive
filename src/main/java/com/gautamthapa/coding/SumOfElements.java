package com.gautamthapa.coding;

import java.util.Arrays;

public class SumOfElements {
    static void main(String[] args) {
        int[] input = {5, 3, 4, 3, 1};

        //1
        int sum = Arrays.stream(input).sum();
        System.out.println("sum : "+sum);

        //2
        int sum2=Arrays.stream(input)
                .reduce(0, Integer::sum);
        System.out.println("sum2 : "+sum2);

    }
}
