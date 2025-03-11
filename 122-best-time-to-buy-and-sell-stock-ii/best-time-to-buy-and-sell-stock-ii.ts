function maxProfit(prices: number[]): number {
    let profit = 0;
    let buyPrice = prices[0];
    for(let i = 0; i < prices.length; i ++){
        if(prices[i] > buyPrice) profit += prices[i] - buyPrice;
        buyPrice = prices[i];
    }
    return profit;
};