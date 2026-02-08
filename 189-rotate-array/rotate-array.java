class Solution {
    public void rotate(int[] nums, int k) {
        int[] helper = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            helper[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i ++){
            nums[i] = helper[i];
        }
    }
}