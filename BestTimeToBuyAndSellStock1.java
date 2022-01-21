package com.company;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length, profit = 0, new_profit = 0, min_price;
        if (n <= 0)
            return 0;

        min_price = prices[0];
        for (int i = 1; i < n; i++) {
            new_profit = prices[i] - min_price;
            profit = Math.max(profit, new_profit);
            min_price = Math.min(min_price, prices[i]);
        }
        return profit;
    }
}
