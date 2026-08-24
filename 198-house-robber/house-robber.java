class Solution {
    public int rob(int[] nums) {
        int[] computedValues = new int[nums.length];
        Arrays.fill(computedValues, -1);
        return rob(nums , 0, computedValues);
    }
    private int rob(int[] nums , int n, int[] computedValues) {
        if(n >= nums.length) return 0;
        else if (n == nums.length - 1) return nums[n];
        else{
            if(computedValues[n] != -1) return computedValues[n];
            int ans = Math.max(nums[n] + rob(nums , n + 2, computedValues), rob(nums , n + 1, computedValues));
            computedValues[n] = ans;
            return ans;
        }
    }
}