class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayLesserOrEqualto(nums, goal) - numSubarrayLesserOrEqualto(nums, goal - 1);
    }
   
    private int numSubarrayLesserOrEqualto(int[] nums, int goal) {
        int result = 0;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < nums.length; r ++) {
            sum += nums[r];
            while(sum > goal && l <= r){
                sum -= nums[l];
                l ++;
            }
            result += r - l + 1;
        }
        return result;
    }

}