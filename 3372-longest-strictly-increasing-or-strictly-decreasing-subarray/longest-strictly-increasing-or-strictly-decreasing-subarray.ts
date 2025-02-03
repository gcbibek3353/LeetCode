function longestMonotonicSubarray(nums: number[]): number {
    if (nums.length === 1) return 1;
    
    let maxLen = 1;
    let incLen = 1, decLen = 1;
    
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            incLen += 1;
            decLen = 1;
        } else if (nums[i] < nums[i - 1]) {
            decLen += 1;
            incLen = 1;
        } else {
            incLen = 1;
            decLen = 1;
        }
        
        maxLen = Math.max(maxLen, incLen, decLen);
    }
    
    return maxLen;
};