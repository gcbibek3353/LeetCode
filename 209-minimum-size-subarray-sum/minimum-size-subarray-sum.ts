function minSubArrayLen(target: number, nums: number[]): number {
    let l = 0;
    let Min = Infinity;
    let curSum = 0;
    for(let r = 0; r < nums.length; r ++){
        curSum += nums[r];
        while(curSum >= target){
            Min = Math.min(Min,r - l + 1);
            curSum -= nums[l];
            l ++;
        }
    }
    return Min === Infinity ? 0 : Min;
};