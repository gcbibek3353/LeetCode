function findMin(nums: number[]): number {
    let ans = Infinity;
    let l = 0;
    let r = nums.length - 1;

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (nums[l] <= nums[m]) {  // left is sorted
            ans = Math.min(ans, nums[l]);
            l = m + 1;
        }
        else {  // right is sorted
            ans = Math.min(ans, nums[m]);
            r = m - 1;
        }
    }

    return ans;
};