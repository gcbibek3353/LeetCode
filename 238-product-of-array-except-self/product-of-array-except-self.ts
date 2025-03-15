function productExceptSelf(nums: number[]): number[] {
    let lp = [];
    let rp = [];
    let ans = [];
    let n = nums.length;
    for(let i = 0; i <= n - 1; i ++) lp[i] = (i === 0) ? nums[0] : nums[i] * lp[i - 1];
    for(let i = n - 1; i >= 0; i --) rp[i] = (i === n - 1) ? nums[n - 1] : rp[i + 1] * nums[i];
    for(let i = 0; i < nums.length; i ++){
        if(i === 0) ans[i] = rp[i + 1];
        else if (i === n - 1) ans[i] = lp[i - 1];
        else ans[i] = lp[i - 1] * rp[i + 1];
    }
    return ans;
};