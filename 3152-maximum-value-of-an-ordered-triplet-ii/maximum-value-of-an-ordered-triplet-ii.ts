function maximumTripletValue(nums: number[]): number {
  const n = nums.length;
  let res = 0;
  let imax = 0;
  let maxDiff = 0;

    for(let k = 0; k < n; k ++){
        res = Math.max(res,maxDiff * nums[k]);
        imax = Math.max(imax,nums[k]);
        maxDiff = Math.max(maxDiff,imax - nums[k]);
    }
    return res;
};