function rearrangeArray(nums: number[]): number[] {
    let ans = [];
    let oddIndex = 1;
    let evenIndex = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            ans[oddIndex] = nums[i];
            oddIndex += 2;
        }
        else {
            ans[evenIndex] = nums[i];
            evenIndex += 2;
        }
    }
    return ans;
}
