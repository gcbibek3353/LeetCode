function productExceptSelf(nums: number[]): number[] {
    let ans = new Array();
    let prefix = 1;
    ans[nums.length - 1] = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        if (i === nums.length - 1) ans[i] = nums[i];
        else ans[i] = ans[i + 1] * nums[i];
    }
    for (let i = 0; i < nums.length; i++) {
        if (i === nums.length - 1) ans[i] = prefix;
        else {
            ans[i] = prefix * ans[i + 1];
            prefix *= nums[i];
        }
    }
    return ans;
}
