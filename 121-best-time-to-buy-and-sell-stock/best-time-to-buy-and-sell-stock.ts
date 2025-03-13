function maxProfit(prices: number[]): number {
  let maxProfit = 0;
  let curMin = prices[0];
  for(let i = 0; i < prices.length; i ++){
    if(prices[i] > curMin) maxProfit = Math.max(maxProfit,prices[i] - curMin);
    else curMin = prices[i];
  }
  return maxProfit;
};