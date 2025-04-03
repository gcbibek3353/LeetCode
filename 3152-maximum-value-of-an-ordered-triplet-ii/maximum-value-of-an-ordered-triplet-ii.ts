function maximumTripletValue(nums: number[]): number {
    let n = nums.length;
    let leftMax = new Array(n).fill(0)
    let rightMax = new Array(n).fill(0);
    
    for(let i = 0; i < n; i ++){
        leftMax[i] = (i === 0) ? nums[i] : Math.max(leftMax[i - 1],nums[i]);
        rightMax[n - i - 1] = (i === 0) ? nums[n - i - 1] : Math.max(rightMax[n - i],nums[n - i - 1]);
    }
    let res = 0;
    // console.log(leftMax);
    // console.log(rightMax);
    for(let j = 1; j <= n - 2; j ++){
        res = Math.max(res, (leftMax[j - 1] - nums[j]) * rightMax[j + 1]);
        // console.log(res,j);
    }
    return res;
};