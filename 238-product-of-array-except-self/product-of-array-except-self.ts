function productExceptSelf(nums: number[]): number[] {
   let result = new Array(nums.length).fill(1);

    let left = 1, right = 1;

    for(let i = 0; i < nums.length; i ++){
        result[i] *= left;
        left *= nums[i];
    }

    for(let i = nums.length - 1; i >= 0; i --){
        result[i] *= right;
        right *= nums[i];
    }

   return result;
};