function numWaterBottles(numBottles: number, numExchange: number): number {
    let ans = numBottles;
    let empty = ans;

    while (empty / numExchange >= 1) {
        numBottles = Math.floor(empty / numExchange);
        ans += numBottles;
        empty = (empty % numExchange) + numBottles;
    }

    return ans;
}
