function check(nums: number[]): boolean {
    let minIndex = 0;
    for(let i = 0; i < nums.length; i ++){
        if(nums[i] > nums[i + 1]) minIndex = i + 1;
    }
    for(let i = 0; i < nums.length - 1; i ++){
        if(nums[(i+minIndex)%nums.length] > nums[(i+1+minIndex) % nums.length]){
            return false;
        }
    }
    return true;
};