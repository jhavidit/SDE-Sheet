package array.day1;

import jdk.nashorn.internal.ir.SplitReturn;

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int profit = 0, min = prices[0], max = prices[1];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= max) {
                max = prices[i];
            }
            if (prices[i] < min) {
                if ((max - min) > profit)
                    profit = max - min;
                min = prices[i];
                max = prices[i];
            }
        }
        if (max - min > profit)
            profit = max - min;
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(arr));
    }


}
