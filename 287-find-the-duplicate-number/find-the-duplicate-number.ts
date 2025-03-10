function findDuplicate(nums: number[]): number {
  let n = nums.length;
  // cyclic sorting
  for(let i = 0; i < n; i ++){
    let cur = nums[i];
    while(nums[cur - 1] != cur){
        let temp = nums[cur - 1];
        nums[cur - 1] = cur;
        cur = nums[i] = temp;
    }
  }

  for(let i = 0; i < n; i ++){
    if(nums[i] != (i + 1)) return nums[i];
  }
  return -1;
};