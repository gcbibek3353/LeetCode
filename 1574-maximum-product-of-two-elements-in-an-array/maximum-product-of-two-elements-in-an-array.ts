function maxProduct(nums: number[]): number {
    if (nums.length < 2) return -1;
    let n1 = 0;
    let n2 = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > n1) {
            n2 = Math.max(n1 , n2);
            n1 = nums[i];
            continue;
        }
        if (nums[i] <= n1 && nums[i] > n2) n2 = nums[i];
    }
    console.log(n1, n2);
    return ((n1 -1) * (n2 - 1))
};