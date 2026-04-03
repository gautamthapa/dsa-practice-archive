package com.gautamthapa.loops;

public class PowerOfNumber {
    public static void main(String[] args) {
        int base = 5;
        int exponent = 4;
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);

        int n = 5;
        int mul = n;
        int pow = 4;
        for (int i = 1; i < pow; i++) {
            mul = mul * n;
        }

        System.out.println("mul " + mul);

        System.out.println("pow " + power(n, pow));
    }

    /*
    * power(base, exp) calculates the power of a number using the method of exponentiation by squaring.
    * It initializes the result to 1 and iteratively multiplies the base to the result when the exponent is even, and squares the base while halving the exponent until the exponent becomes zero. This method is efficient and works in logarithmic time complexity O(log(exp)).
    * */
    public static int power(int base, int exp){
        int result = 1;

        while (exp > 0) {
            if (exp % 2 == 0) {
                result *= base;
            }

            base *= base;
            exp /= 2;
        }

        return result;
    }
}
