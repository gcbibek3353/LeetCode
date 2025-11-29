class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numSubArrayLesserOREqual(nums, k) - numSubArrayLesserOREqual(nums, k - 1);
    }

    private int numSubArrayLesserOREqual(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int ans = 0;
        int curSum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            // curSum += nums[r];
            if(nums[r] % 2 == 1) curSum ++;
            while (curSum > goal && l <= r){
                // curSum -= nums[l++];
                if(nums[l] % 2 == 1) curSum --;
                l ++;
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}