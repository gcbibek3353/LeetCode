function longestSubarray(nums: number[]): number {
    let max:number=Math.max(...nums);
    let count:number=0;
    let res:number=0;
    for(let i=0;i<nums.length;i++){
        nums[i]===max?count++:count=0;
        res=Math.max(count,res);
    }
    return res;
};