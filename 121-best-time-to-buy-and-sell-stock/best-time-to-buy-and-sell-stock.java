class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cp = prices[0];
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] < cp) {
                cp = prices[i];
                continue;
            }
            else if (prices[i] > cp) {
                profit = Math.max(profit , prices[i] - cp);
            }
        }
        return profit;
    }
}