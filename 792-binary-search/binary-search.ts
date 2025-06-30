function search(nums: number[], target: number): number {
    if (nums.length === 0) return -1;
    if (nums.length === 1) return (nums[0] === target) ? 0 : -1;
    let l = 0;
    let r = nums.length - 1;
    while (l <= r) {
        let mid = Math.floor((l + r) / 2);
        if (nums[mid] === target) return mid;
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
};