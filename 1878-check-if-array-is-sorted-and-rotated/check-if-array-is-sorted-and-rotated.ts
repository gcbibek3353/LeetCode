function check(nums: number[]): boolean {
    let minIndex = 0;
    let n = nums.length;
    for(let i = 0;i < n - 1; i ++){
        if(nums[i] > nums[i + 1]) minIndex = i + 1;
    }
    for(let i = 0; i < n - 1; i ++){
        if(nums[(i + minIndex) % n] > nums[(i + minIndex + 1) % n]) return false;
    }
    return true;
};