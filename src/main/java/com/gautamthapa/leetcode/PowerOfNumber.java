package com.gautamthapa.leetcode;

public class PowerOfNumber {
    static void main() {
        int base = 4;
        int num = 16;

        System.out.println("Method 1 : Power of " + base + " " + num + " is " + checkPowerOfBase1(num, base));
        System.out.println("Method 2 : Power of " + base + " " + num + " is " + checkPowerOfBase2(num, base));
    }

    private static String checkPowerOfBase2(int num, int base) {
        if (num <= 0 || base <= 0)
            return "invalid";

        while (num != 1) {
            if (num % base == 1)
                return "invalid";

            num /= base;
        }
        return "valid";
    }

    private static String checkPowerOfBase1(int num, int base) {
        if (num <= 0 || base <= 0)
            return "invalid";

        int pow = base;
        for (int i = 1; i <= num; i++) {
            pow = pow * base;
            if (num == pow)
                return "valid";
        }
        return "invalid";
    }
}
