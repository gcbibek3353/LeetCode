function searchInsert(nums: number[], target: number): number {
    let l = 0; 
    let r = nums.length - 1;
    let mid;
    while (l <= r ){
        mid = Math.floor((l + r) / 2);
        if(nums[mid] === target) return mid;
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
   return l;
};