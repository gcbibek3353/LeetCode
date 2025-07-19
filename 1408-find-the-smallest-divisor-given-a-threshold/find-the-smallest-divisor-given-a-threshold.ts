function smallestDivisor(nums: number[], threshold: number): number {
    let l = 1;
    let r = Math.max(...nums);
    let ans = Number.MAX_SAFE_INTEGER;
    const getSumAfterDivide = (m : number) : number => {
        let curSum = 0;
        for(let i = 0; i < nums.length; i ++){
            curSum += Math.ceil(nums[i] / m);
        }
        return curSum;
    }

    while(l <= r) {
        let m = Math.floor( ( l + r) / 2);
        let sum = getSumAfterDivide(m);
        if(sum <= threshold) {
            ans = Math.min(ans , m);
            r = m - 1;
        }
        else l = m + 1;
    }

    return ans;
};