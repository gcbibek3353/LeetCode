function maxAscendingSum(nums: number[]): number {
    let sum = nums[0];
    let maxSum = nums[0];
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            sum += nums[i];
        }
        else {
            sum = nums[i];
        }
        if (sum > maxSum) maxSum = sum;
    }
    return maxSum;
}