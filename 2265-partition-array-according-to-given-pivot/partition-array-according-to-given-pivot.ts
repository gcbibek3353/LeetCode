function pivotArray(nums: number[], pivot: number): number[] {
    let sm = [];
    let lg = [];
    let count = 0;
    let ans = [];
    for(let i = 0; i < nums.length; i ++){
        if(nums[i] < pivot) sm.push(nums[i]);
        else if(nums[i] === pivot) count ++;
        else lg.push(nums[i]);
    }
    for(let i = 0; i < sm.length; i ++) ans.push(sm[i]);
    for(let i = 1; i <= count; i ++) ans.push(pivot);
    for(let i = 0; i < lg.length; i ++) ans.push(lg[i]);
    return ans;
};