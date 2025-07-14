function findPeakElement(nums: number[]): number {
    let n = nums.length;
    if (n === 1) return 0;
    if (nums[0] > nums[1]) return 0;
    if (nums[n - 1] > nums[n - 2]) return n - 1;

    let l = 0;
    let r = n - 1;

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if ((nums[m] > nums[m - 1]) && (nums[m] > nums[m + 1])) return m;
        else if (nums[m] < nums[m - 1]) r = m - 1;  // peak exist in left
        else l = m + 1;  // peak exist in right
    }

    return -1;
};