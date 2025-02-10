function maxProfit(prices: number[]): number {
    let maxProfit = 0;
    let minPrice = Number.MAX_SAFE_INTEGER;
    for(let i = 0; i < prices.length; i ++){
        if(prices[i] < minPrice){
            minPrice = prices[i];
        }
        else{
            let profit = prices[i] - minPrice;
            maxProfit = Math.max(profit,maxProfit);
        }
    }
    return maxProfit;
};