class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int ans = Integer.MAX_VALUE;
        int curSum = 0;
        for(int j = 0; j < nums.length; j ++) {
            curSum += nums[j];
            if(curSum >= target) ans = Math.min(ans , j - i + 1);
            while(i < j && curSum >= target) {
                curSum -= nums[i];
                i ++;
                if(curSum >= target) ans = Math.min(ans , j - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}