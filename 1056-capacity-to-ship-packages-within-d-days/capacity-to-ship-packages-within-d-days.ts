function shipWithinDays(weights: number[], days: number): number {
    let l = Math.max(...weights);
    let r = weights.reduce((n, accum) => n + accum, 0);
    let ans = Infinity;

    const isValid = (capacity: number): boolean => {
        let curSum = 0;
        let curDays = 1;
        for (let i = 0; i < weights.length; i++) {
            if (curSum + weights[i] > capacity) {
                curDays++;
                curSum = weights[i];
            }
            else curSum += weights[i];
        }
        return curDays <= days;
    }

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (isValid(m)) {
            ans = Math.min(ans, m);
            r = m - 1;
        }
        else l = m + 1;
    }
    return ans;
};