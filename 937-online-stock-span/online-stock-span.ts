class StockSpanner {
  constructor() {}

  private stockPrices = [];

  next(price: number): number {
    let span = 1;

    for (let i = this.stockPrices.length - 1; i >= 0; i--) {
      if (this.stockPrices[i] > price) {
        break;
      }

      span++;
    }

    // Only add to array after computing span to prevent double counting itself
    this.stockPrices.push(price);

    return span;
  }
}