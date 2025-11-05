class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        return noOfSubarraysLesserOrEqual(nums , goal) - noOfSubarraysLesserOrEqual(nums , goal - 1);
    }

      public int noOfSubarraysLesserOrEqual(int[] nums , int goal) {
        if(goal < 0) return 0;
        int i = 0;
        int curSum = 0;
        int ans = 0;
        for(int j = 0; j < nums.length; j ++) {
            curSum += nums[j]%2;
            while(curSum > goal && i <= j) curSum -= nums[i ++]%2;
        ans += (j - i + 1);
        }
        return ans;
    }
    
}