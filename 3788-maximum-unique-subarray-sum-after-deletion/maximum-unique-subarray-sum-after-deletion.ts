function maxSum(nums: number[]): number {
    let st = new Set<number>(nums);
    let isPositivePresent = false;
    let maxNegative = -Infinity;
    let ans = 0;
    for (let num of st) {
        if (num >= 0) isPositivePresent = true;
        if (num < 0) maxNegative = Math.max(maxNegative, num);
        ans = Math.max(ans, ans + num)
    }
    return isPositivePresent ? ans : maxNegative;
};