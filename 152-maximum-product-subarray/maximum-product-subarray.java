class Solution {
    public int maxProduct(int[] nums) {
       if(nums.length == 0) return 0;
       int overallMax = nums[0];
       int maxSoFar = nums[0];
       int minSoFar = nums[0];
       for(int i = 1; i < nums.length;i ++) {
        int curNum = nums[i];
        int tempMax = maxSoFar;
        maxSoFar = Math.max(curNum , Math.max(tempMax * curNum , minSoFar * curNum));
        minSoFar = Math.min(curNum , Math.min(tempMax * curNum , minSoFar * curNum));
        overallMax = Math.max(overallMax , maxSoFar);
       }
       return overallMax;
    }
}