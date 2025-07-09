/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): void {
    let ans = [];
    let n = nums.length;
    for (let i = 0; i < n; i++) {
        ans[(i + k) % n] = nums[i];
    }
    for (let i = 0; i < n; i++) nums[i] = ans[i];
};