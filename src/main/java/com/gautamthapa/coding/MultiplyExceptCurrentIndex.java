package com.gautamthapa.coding;

import java.util.Arrays;

public class MultiplyExceptCurrentIndex {
    static void main() {
        int[] inputs = {1, 2, 3, 4};

        // Bruteforce
        int[] output1 = getMultipliesAllExceptCurrentIndex1(inputs);

        // Optimized
        int[] output2 = getMultipliesAllExceptCurrentIndex2(inputs);


        System.out.println("output1 : " + Arrays.toString(output1));
        System.out.println("output2 : " + Arrays.toString(output2));

    }

    private static int[] getMultipliesAllExceptCurrentIndex2(int[] inputs) {
        int n = inputs.length;

        int prefix = 1;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = prefix;
            prefix *= inputs[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix;
            suffix *= inputs[i];
        }

        return output;
    }

    private static int[] getMultipliesAllExceptCurrentIndex1(int[] inputs) {
        // total multiples
        int mul = 1;
        for (int num : inputs) {
            mul *= num;
        }

        int[] output = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            output[i] = mul / inputs[i];
        }

        return output;
    }
}
