function sortedSquares(nums: number[]): number[] {
    let l = 0;
    let r = nums.length - 1;
    let i = r;
    const ans = new Array(nums.length);

   while(l <= r){
    let lNumber = nums[l] * nums[l];
    let rNumber = nums[r] * nums[r];
    if(lNumber >= rNumber) {
        ans[i --] = lNumber;
        l ++;
    }
    else{
     ans[i --] = rNumber;
    r--;
    }
   }
    return ans;
};