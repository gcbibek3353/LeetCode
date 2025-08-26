function fourSum(nums: number[], target: number): number[][] {
    const ans: number[][] = [];
    nums.sort((a, b) => a - b);

    function twoSum(l: number, r: number, twosumtarget: number, ind1: number, ind2: number): void {
        while (l < r) {
            const sum = nums[l] + nums[r];
            if (sum < twosumtarget) {
                l++;
            } else if (sum > twosumtarget) {
                r--;
            } else {
                ans.push([nums[ind1], nums[ind2], nums[l], nums[r]]);
                l++;
                r--;
                // skip duplicates for l
                while (l < r && nums[l] === nums[l - 1]) l++;
                // skip duplicates for r
                while (l < r && nums[r] === nums[r + 1]) r--;
            }
        }
    }

    for (let i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) continue; // skip duplicate i
        for (let j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] === nums[j - 1]) continue; // skip duplicate j
            twoSum(j + 1, nums.length - 1, target - nums[i] - nums[j], i, j);
        }
    }

    return ans;
}
