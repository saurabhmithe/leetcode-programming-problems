package Arrays.Easy;

public class BestTimeToBuyAndSellStock2 {

    // Say you have an array for which the ith element is the price of a given stock on day i.
    // Design an algorithm to find the maximum profit. You may complete as many transactions
    // as you like (i.e., buy one and sell one share of the stock multiple times).

    // Note: You may not engage in multiple transactions at the same time
    // (i.e., you must sell the stock before you buy again).

    // Example 1:
    // Input: [7,1,5,3,6,4]
    // Output: 7
    // Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    // Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    // Example 2:
    // Input: [1,2,3,4,5]
    // Output: 4
    // Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    // Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
    // engaging multiple transactions at the same time. You must sell before buying again.

    // Example 3:
    // Input: [7,6,4,3,1]
    // Output: 0
    // Explanation: In this case, no transaction is done, i.e. max profit = 0.


    /**
     * The intuition we follow here is that if we see a dip in price on the next day,
     * we sell today and buy again tomorrow. If we keep on seeing a rise in price from
     * the day we bought the stock, we keep on incrementing the sell pointer to keep up
     * with the highest price that we can get after we bought the stock.
     * Repeat until we reach the end of the array. There can be a case where we buy a stock
     * on the last day. Since there is no other day after that, we need to sell the stock
     * on the same day and add the profit to maxProfit which is done after the loop ends.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 2ms
     * Runtime beats 82.43% of Java Submissions
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buy = 0;
        int sell = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                maxProfit += prices[sell] - prices[buy];
                buy = i + 1;
                sell = i + 1;
            } else {
                sell += 1;
            }
        }
        maxProfit += prices[sell] - prices[buy];
        return maxProfit;
    }

}
