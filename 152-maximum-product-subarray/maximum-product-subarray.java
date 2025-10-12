class Solution {
    public int maxProduct(int[] nums) {
      int highestPositive = nums[0];
      int highestNegative = nums[0];
      int ans = nums[0];
      for(int i = 1; i < nums.length; i ++) {
        int tempMax = highestPositive;
        highestPositive = Math.max(Math.max(tempMax * nums[i] , highestNegative * nums[i]) , nums[i]);
        highestNegative = Math.min(Math.min(tempMax * nums[i] , highestNegative * nums[i]) , nums[i]);
        ans = Math.max(highestPositive , ans);
      }
      return ans;
    }
}