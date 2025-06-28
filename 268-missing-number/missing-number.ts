function missingNumber(nums: number[]): number {
    let xorr = 0;
    for (let i = 0; i < nums.length; i++) {
        xorr ^= (i + 1) ^ nums[i];
    }
    return xorr;
};