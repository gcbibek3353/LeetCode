function maximumTripletValue(nums: number[]): number {
    let maxValue = -Infinity;
    for(let i = 0; i <= nums.length - 3; i ++){
        for(let j = i + 1; j <= nums.length - 2; j ++){
            for(let k = j + 1; k <= nums.length - 1; k ++) {
                let value = (nums[i] - nums[j]) * nums[k];
                maxValue = Math.max(maxValue, value);
            }
        }
    }
    return maxValue < 0 ? 0 : maxValue;
};