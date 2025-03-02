function removeDuplicates(nums: number[]): number {
    let k = 2;
    for(let i = 2; i < nums.length; i ++){
            // console.log(i,k,nums);
        if(nums[i] !== nums[k - 2]){
            nums[k] = nums[i];
            k++;
        }

    }
    return k;
};