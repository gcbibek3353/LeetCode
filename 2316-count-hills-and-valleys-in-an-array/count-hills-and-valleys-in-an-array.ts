function countHillValley(nums: number[]): number {
    const closestNonEqualLeft = (i: number): number => {
        while (i > 0 && nums[i] === nums[i - 1]) i--;
        return nums[i - 1];
    }
    const closestNonEqualRight = (i: number): number => {
        while (i < nums.length - 1 && nums[i] === nums[i + 1]) i++;
        return nums[i + 1];
    }

    let ans = 0;
    for (let i = 1; i < nums.length - 1; i++) {
        const closestRight = closestNonEqualRight(i);
        const closestLeft = closestNonEqualLeft(i);
        if (nums[i] !== nums[i - 1]) {
            if (nums[i] > closestRight && nums[i] > closestLeft) ans++;
            else if (nums[i] < closestRight && nums[i] < closestLeft) ans++;
        }
    }

    return ans;
};