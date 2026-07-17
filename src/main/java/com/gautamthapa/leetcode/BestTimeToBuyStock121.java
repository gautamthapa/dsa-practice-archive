package com.gautamthapa.leetcode;

public class BestTimeToBuyStock121 {
    static void main() {
        int[] prices = {2, 5, 3, 4, 9, 2};

        int maxProfit = calculateMaxProfit(prices);
        System.out.println("maxProfit : " + maxProfit);
    }

    private static int calculateMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
