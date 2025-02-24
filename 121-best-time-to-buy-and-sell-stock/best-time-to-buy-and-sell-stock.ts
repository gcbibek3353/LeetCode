function maxProfit(prices: number[]): number {
  let lowerPrice = prices[0];
  let maxProfit = 0;
  for(let i = 0; i < prices.length; i ++){
    if(prices[i] < lowerPrice) lowerPrice = prices[i];
    else maxProfit = Math.max(maxProfit,prices[i] - lowerPrice);
  }
  return maxProfit;
};