function majorityElement(nums: number[]): number {
    let major = nums[0];
    let count = 1;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === major) count++;
        else {
            if (count === 0) {
                major = nums[i];
                count = 1;
            }
            else count--;
        }
    }

    return major;
};