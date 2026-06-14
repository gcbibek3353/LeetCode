class Solution {
    public int removeDuplicates(int[] nums) {
        int keepPosition = 1;
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] != nums[i - 1]) nums[keepPosition ++] = nums[i];
        }
        return keepPosition;
    }
}