/**
 Do not return anything, modify nums in-place instead.
 */
function nextPermutation(nums: number[]): void {

    let i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) i--;
    if (i >= 0) {
        let j = nums.length - 1;
        while (nums[i] >= nums[j]) j--;
        swap(nums, i, j);
    }

    reverse(nums, i + 1);

};

const swap = (nums: number[], i: number, j: number): void => {
    [nums[i], nums[j]] = [nums[j], nums[i]];
}
const reverse = (nums: number[], start: number): void => {
    let end = nums.length - 1;
    while (start < end) swap(nums, start++, end--);
}
