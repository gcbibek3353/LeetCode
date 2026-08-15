class Solution {
    public int longestSubsequence(int[] nums) {
        boolean isAllZeros = true;
        int totalXor = 0;
        int n = nums.length;

        for(int num : nums) {
            totalXor ^= num;
            if(num > 0) isAllZeros = false;
        }

        if(totalXor != 0) return n;

        return isAllZeros ? 0 : n - 1;
    }
}