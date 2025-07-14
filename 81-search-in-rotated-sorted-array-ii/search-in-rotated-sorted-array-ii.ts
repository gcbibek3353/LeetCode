function search(nums: number[], target: number): boolean {
    let n = nums.length;
    let l = 0;
    let r = n - 1;

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (nums[m] === target) return true;
        else if ((nums[m] === nums[l]) && (nums[m] === nums[r])) {
            l++;
            r--;
            continue;
        }
        else if (nums[l] <= nums[m]) {  // left is sorted
            if (nums[l] <= target && nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        else {  // right is sorted
            if (nums[r] >= target && nums[m] < target) l = m + 1;
            else r = m - 1;
        }
    }

    return false;
};