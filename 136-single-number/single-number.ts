function singleNumber(nums: number[]): number {
    return nums.reduce((num , accum) => num ^ accum , 0);
};