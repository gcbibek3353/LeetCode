function productExceptSelf(nums: number[]): number[] {
    const l = nums.length;
  const res = new Array(l).fill(1);
  let prefix = 1,
    suffix = 1;

  for (let i = 0; i < l; i++) {
    res[i] *= prefix;
    res[l - 1 - i] *= suffix;
    prefix *= nums[i];
    suffix *= nums[l - 1 - i];
  }

  return res;
};