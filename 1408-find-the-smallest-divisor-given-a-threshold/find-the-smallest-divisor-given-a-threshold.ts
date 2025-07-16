function smallestDivisor(nums: number[], threshold: number): number {
    let l = 0;
    let r = Math.max(...nums); // O(n)
    let ans = Infinity;

    const isValid = (m: number): boolean => {
        let curSum = 0;
        for (let i = 0; i < nums.length; i++) {
            let dividedAns = Math.ceil(nums[i] / m);
            curSum += dividedAns;
        }
        return curSum <= threshold;
    }

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (isValid(m)) {
            ans = Math.min(ans, m);
            r = m - 1;
        }
        else l = m + 1;
    }
    return ans;
};