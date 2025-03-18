function maxProfit(prices: number[]): number {
    let curMin = prices[0];
    let maxProfit = 0;
    for(let i = 1; i < prices.length; i ++){
         if(prices[i] > curMin)
         maxProfit = Math.max(maxProfit,prices[i] - curMin);
         else 
         curMin = Math.min(curMin,prices[i]);
    }
    return maxProfit;
};