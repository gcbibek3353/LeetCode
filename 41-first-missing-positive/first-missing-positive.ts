function firstMissingPositive(nums: number[]): number {
    let n = nums.length;

    // Cyclic sorting only for numbers that lie between 1 to n.
    for(let i = 0; i < n; i ++){
        while(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
            let temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
    }
    // finding the first missing positive
    for(let i = 1; i <= n; i ++)
        if(i != nums[i - 1]) return i;
        
    return n + 1;
};