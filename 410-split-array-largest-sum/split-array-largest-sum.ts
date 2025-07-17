function splitArray(nums: number[], k: number): number {
    let l = Math.max(...nums);
    let r = nums.reduce((a, b) => a + b, 0);
    let result = r;

    const countPartition = (maxSum: number): number => {
        let partition = 1;
        let curSum = 0;
        for (let i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > maxSum) {
                partition++;
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
        }
        return partition;
    };

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        let partition = countPartition(m);
        if (partition <= k) {
            result = m;
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    return result;
}
