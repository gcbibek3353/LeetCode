class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int curSum = 0;
        int min_len = Integer.MAX_VALUE;
        for(int r = 0; r < nums.length; r ++) {
            curSum += nums[r];
            while(curSum >= target){
                min_len = Math.min(min_len , r - l + 1);
                curSum -= nums[l];
                l ++;
            }
        }
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}