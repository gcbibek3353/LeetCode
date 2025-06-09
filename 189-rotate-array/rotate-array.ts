/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): void {
  let result = new Array<number>();
  for(let i = 0; i < nums.length; i ++){
    result[(i + k ) % nums.length] = nums[i];
  }
  for(let i = 0; i < nums.length; i ++) {
    nums[i] = result[i];
  }
};