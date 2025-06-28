function missingNumber(nums: number[]): number {
    let n = nums.length;
    let sum = 0;
    for(let i = 0; i < n ; i ++){
        sum += nums[i];
    }
    let mathSum = (n * (n + 1))/2;
    return (mathSum - sum);
};