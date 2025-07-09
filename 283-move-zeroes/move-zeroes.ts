
function moveZeroes(nums: number[]): void {
    let k = 0; 
    for(let i = 0; i < nums.length; i ++){
        if(nums[i] !== 0) nums[k ++] = nums[i];
    }
    for(let i = k ; i < nums.length; i ++){
        nums[i] = 0;
    }
};