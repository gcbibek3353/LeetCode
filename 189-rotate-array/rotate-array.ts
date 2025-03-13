/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): void {
  let newArr = new Array<number>(nums.length);
  for(let i = 0; i < nums.length; i ++) newArr[(i + k) % nums.length] = nums[i];
  for(let i = 0; i < nums.length; i ++) nums[i] = newArr[i];
};