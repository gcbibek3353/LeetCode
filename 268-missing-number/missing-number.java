class Solution {
    public int missingNumber(int[] nums) {
        int xorr = 0;
        for(int i = 1; i <= nums.length; i ++) {
            int xor = nums[i - 1] ^ i;
            xorr ^= xor;
        }
        return xorr;
    }
}