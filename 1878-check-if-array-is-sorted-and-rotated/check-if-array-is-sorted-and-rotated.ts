function check(nums: number[]): boolean {
    let minIndex = -1;

    for (let i = nums.length - 2; i >= 0; i--) {
        if (nums[i] > nums[i + 1]) {
            minIndex = i + 1;
        }
    }
    if (minIndex === -1) return true;

    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[(i + minIndex) % nums.length] > nums[(i + minIndex + 1) % nums.length]){
            console.log(i , minIndex);
        return false;
        } 
    }

    return true;
};