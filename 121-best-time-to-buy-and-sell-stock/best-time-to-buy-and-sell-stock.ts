function maxProfit(prices: number[]): number {
    let min = prices[0];
    let maxProfit = 0;
    for (let i = 1; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        const profit = prices[i] - min;
        maxProfit = Math.max(maxProfit, profit);
    }
    return maxProfit;
};