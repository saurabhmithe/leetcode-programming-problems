package Array.Easy;

public class BestTimeToBuyAndSellStock {

     /*

     Say you have an array for which the ith element is the price of a given stock on day i.
     If you were only permitted to complete at most one transaction (i.e., buy one and sell
     one share of the stock), design an algorithm to find the maximum profit.
     Note that you cannot sell a stock before you buy one.

     Example 1:
     Input: [7,1,5,3,6,4]
     Output: 5
     Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     Not 7-1 = 6, as selling price needs to be larger than buying price.

     Example 2:
     Input: [7,6,4,3,1]
     Output: 0
     Explanation: In this case, no transaction is done, i.e. max profit = 0.

     */


    /**
     * In this problem, we need to buy and sell just once. To get the maximum profit,
     * we need to find two numbers with maximum difference such that the smaller one
     * comes before the larger one. To do this, we mark the first element as minimum.
     * Then as we progress down the array, if we find a number that is lesser than the
     * current minimum, we mark it as minimum. If we find an element that is greater
     * than the current minimum, and the difference between the current and minimum is
     * greater than the maxProfit we have made so far, we update the maxProfit.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 2ms
     * Runtime beats 92.30% of Java submissions
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) maxProfit = Math.max(maxProfit, prices[i] - min);
            else min = prices[i];
        }
        return maxProfit;
    }

}
