function numWaterBottles(numBottles: number, numExchange: number): number {
    let ans = numBottles;
    let empty = numBottles;

    while (empty >= numExchange) {
        let newBottles = Math.floor(empty / numExchange);
        ans += newBottles;
        empty = (empty % numExchange) + newBottles;
    }

    return ans;
}
