function check(nums: number[]): boolean {
    let dip = -1;
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            dip = i + 1;
            break;
        }
    }
    for (let i = 0; i < nums.length - 1; i++) {
        let index = ((i + dip) % nums.length);
        if (nums[index] > nums[(index + 1) % nums.length]) return false;
    }
    return true;
};