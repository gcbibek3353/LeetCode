class Solution {
    public int maxProfit(int[] prices) {
        int prefixMin = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] < prefixMin) prefixMin = prices[i];
            int curProfit = prices[i] - prefixMin;
            maxProfit = Math.max(maxProfit , curProfit);
        }
        return maxProfit;
    }
}