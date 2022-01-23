package com.company;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length, min_price, max_price, profit, prefix_profit = 0;

        if (n <= 0)
            return 0;

        int[] suffix_profit = new int[n + 1];
        suffix_profit[n - 1] = 0;
        max_price = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int new_profit = max_price - prices[i];
            suffix_profit[i] = Math.max(suffix_profit[i + 1], new_profit);
            max_price = Math.max(max_price, prices[i]);
        }

        min_price = prices[0];
        profit = suffix_profit[0];

        for (int i = 1; i < n; i++) {
            int new_profit = prices[i] - min_price;
            prefix_profit = Math.max(prefix_profit, new_profit);
            min_price = Math.min(min_price, prices[i]);

            int profit_with_two_transaction = prefix_profit + suffix_profit[i];
            profit = Math.max(profit, profit_with_two_transaction);
        }
        return profit;
    }
}
