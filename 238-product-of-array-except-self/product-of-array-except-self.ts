function productExceptSelf(nums: number[]): number[] {
    let n = nums.length;
  let rightArray = [];
  rightArray[n - 1] = nums[n - 1]; 
  for(let i = nums.length - 2; i >= 0; i --) {
    rightArray[i] = rightArray[i + 1] * nums[i];
  }
  let leftProduct = nums[0];
    let result = [];
  for(let i = 0; i < n; i ++) {
    if(i === 0) result[i] = rightArray[i + 1];
    else if(i === n - 1) result[i] = leftProduct; 
    else {
    let ans = leftProduct * rightArray[i + 1];
    result[i] = ans;
    leftProduct *= nums[i];
    }
  }
return result;
};