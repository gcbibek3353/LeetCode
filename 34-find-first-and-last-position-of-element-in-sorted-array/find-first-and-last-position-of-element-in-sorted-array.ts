function searchRange(nums: number[], target: number): number[] {
    function findFirst(): number {
        let l = 0, r = nums.length - 1, res = -1;
        while (l <= r) {
            let mid = Math.floor((l + r) / 2);
            if (nums[mid] === target) {
                res = mid;
                r = mid - 1; // search left part
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    function findLast(): number {
        let l = 0, r = nums.length - 1, res = -1;
        while (l <= r) {
            let mid = Math.floor((l + r) / 2);
            if (nums[mid] === target) {
                res = mid;
                l = mid + 1; // search right part
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    const first = findFirst();
    const last = findLast();

    return [first, last];
}
