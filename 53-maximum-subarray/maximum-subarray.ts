function maxSubArray(nums: number[]): number {
    let leftIndex = 0;
    let rightIndex = -1;
    let sum = 0;
    let maxSum = -Infinity;
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum > maxSum) {
            rightIndex = i;
            maxSum = sum;
        }
        if (sum <= 0) {
            leftIndex = i;
            sum = 0;
        }
    }
    return maxSum;
};