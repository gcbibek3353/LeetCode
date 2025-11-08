class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int curSum = 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            curSum += nums[j];
            if (curSum >= target)
                ans = Math.min(j - i + 1, ans);
            while (i < j && curSum >= target) {
                curSum -= nums[i];
                i++;
               if (curSum >= target) ans = Math.min(j - i + 1, ans);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}