function minSubArrayLen(target: number, nums: number[]): number {
    let i = 0;
    let minLength = Infinity;
    let curSum = 0;
    for (let j = 0; j < nums.length; j++) {
        curSum += nums[j];
        while(curSum >= target) {
            minLength = Math.min(minLength, j - i + 1);
            curSum -= nums[i];
            i++;
        }

    }
    return minLength === Infinity ? 0 : minLength;
};