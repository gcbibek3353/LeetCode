function productExceptSelf(nums: number[]): number[] {
    let L = nums[0];
    let ans = [];
    for(let i = nums.length - 1; i >= 0; i -- ){
        ans[i] = (i === nums.length - 1) ? nums[i] : nums[i] * ans[i + 1];
    }
    for(let i = 0; i < nums.length; i ++){
        if(i === 0) ans[i] = ans[i + 1];
        else if(i === nums.length - 1) ans[i] = L;
        else{
            ans[i] = L * ans[i + 1];
            L *= nums[i];
        }
    }
    return ans;
};