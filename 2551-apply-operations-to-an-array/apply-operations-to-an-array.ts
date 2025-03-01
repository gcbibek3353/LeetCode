function applyOperations(nums: number[]): number[] {
    for(let i = 0; i < nums.length - 1; i ++){
        if(nums[i] === nums[i + 1]){
            nums[i] *= 2;
            nums[i + 1] = 0;
        }
    }
    let j = 0;
    while(nums[j] != 0 && j < nums.length) j ++;

    for(let i = j; i < nums.length; i ++){
        if(nums[i] != 0){
            let temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j ++;
        }

    }
    return nums;
};