class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] computedValues = new int[nums.length];
        Arrays.fill(computedValues , -1);
        int[] computedValues2 = new int[nums.length];
        Arrays.fill(computedValues2 , -1);
        return Math.max(rob(nums, 0, nums.length - 2, computedValues), rob(nums, 1, nums.length - 1, computedValues2));        
    }

    private int rob(int[] nums , int n, int end, int[] computedValues) {
        if(n > end) return 0;
        if(computedValues[n] != -1) return computedValues[n];
        return computedValues[n] = Math.max(rob(nums , n + 1,end, computedValues), nums[n] + rob(nums , n + 2,end, computedValues));
    }

    // private int getMax(int[] nums, int start, int end) {
    //     int prevRob = 0, maxRob = 0;
 
    //     for (int i = start; i <= end; i++) {
    //         int temp = Math.max(maxRob, prevRob + nums[i]);
    //         prevRob = maxRob;
    //         maxRob = temp;
    //     }

    //     return maxRob;
    // }    
}