function maximumTripletValue(nums: number[]): number {
    let n = nums.length;
    let maxValue = -Infinity;
    for(let i = 0; i <= n - 3; i ++){
        for(let j = i + 1; j <= n - 2; j ++){
            for(let k = j + 1; k <= n - 1; k ++) {
                let value = (nums[i] - nums[j]) * nums[k];
                maxValue = Math.max(maxValue, value);
            }
        }
    }
    return maxValue < 0 ? 0 : maxValue;
};