class Solution {
    public int removeElement(int[] nums, int val) {
        int keepPosition = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != val) nums[keepPosition ++] = nums[i];
        }
        return keepPosition;
    }
}