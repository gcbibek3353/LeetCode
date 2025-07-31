function subsets(nums: number[]): number[][] {
    let n = 2 ** nums.length;
    let ans = [];
    for (let i = 0; i < n; i++) {
        let curArr = [];
        for (let j = 0; j < nums.length; j++) {
            let bitMask = 1 << j;
            let bit = ((bitMask & i) === 0) ? 0 : 1;
            if (bit === 1) curArr.push(nums[j]);
        }
        ans.push(curArr);
    }
    return ans;
};