function productExceptSelf(nums: number[]): number[] {
    let lp = nums[0];
    let ans = [];
    let n = nums.length;
    for(let i = n - 1; i >= 0; i --) ans[i] = (i === n - 1) ? nums[n - 1] : ans[i + 1] * nums[i];
    for(let i = 0; i < nums.length; i ++){
        if(i === 0) ans[i] = ans[i + 1];
        else if (i === n - 1) ans[i] = lp;
        else {
            ans[i] = lp * ans[i + 1];
            lp = lp * nums[i];
        }
    }
    return ans;
};