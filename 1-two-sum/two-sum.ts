function twoSum(nums: number[], target: number): number[] {
   const mp = new Map<number, number>();

   for(let i = 0; i < nums.length; i ++) {
    const key = target - nums[i];
    if(mp.has(key)) return [i , mp.get(key)];
    else mp.set(nums[i] , i);
   }
};