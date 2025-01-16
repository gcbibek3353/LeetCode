function subsets(nums: number[]): number[][] {
    let arr = [];
    for(let i = 0; i < Math.pow(2,nums.length); i ++){
        let subarr = [];
        for(let j = 0; j < 32; j ++){
            let mask = 1 << j;
            if((mask & i) != 0) subarr.push(nums[j]);
        }
        arr.push(subarr);
    }
    return arr;
};