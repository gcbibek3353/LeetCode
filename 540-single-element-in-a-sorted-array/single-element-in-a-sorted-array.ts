function singleNonDuplicate(nums: number[]): number {
    let n = nums.length;
    if (n === 1) return nums[0];
    if (nums[0] !== nums[1]) return nums[0];
    if (nums[n - 1] !== nums[n - 2]) return nums[n - 1];

    let l = 1;
    let r = n - 2;

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if ((nums[m] !== nums[m - 1]) && (nums[m] !== nums[m + 1])) return nums[m];
        else if (
            ((m % 2 === 0) && (nums[m] === nums[m + 1])) ||
            ((m % 2 !== 0) && (nums[m] === nums[m - 1]))
        ) {  // ans in right
            l = m + 1;
        }
        else r = m - 1;  // ans in left
    }
    return -1;
};