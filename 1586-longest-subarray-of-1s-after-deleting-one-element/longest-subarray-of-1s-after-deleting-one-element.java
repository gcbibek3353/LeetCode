class Solution {
    public int longestSubarray(int[] nums) {
        int i;
        int j = 0;
        int k = 1;
        int zeroCount = 0;
        int maxCount = 0;

        for(i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) zeroCount ++;
            while(zeroCount > k) {
                if(nums[j] == 0) zeroCount --;
                j ++;
            }
            int curWindowSize = i - j;
            maxCount = Math.max(maxCount , curWindowSize);
        }
        return maxCount;
    }
}