function missingNumber(nums: number[]): number {
    let n = nums.length;
    const MathSum = (n * (n + 1)) / 2;
    let sum = nums.reduce((accum , n) => accum + n);
    return MathSum - sum;
};