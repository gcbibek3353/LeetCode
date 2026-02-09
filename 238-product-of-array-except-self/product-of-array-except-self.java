class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int leftProduct = 1;
        for(int i = nums.length - 1; i >= 0; i --) {
            if(i == nums.length - 1) ans[i] = nums[i];
            else ans[i] = nums[i] * ans[i + 1];
        }
        for(int i = 0; i < nums.length; i ++) {
            if(i == nums.length - 1) ans[i] = leftProduct;
            else ans[i] = leftProduct * ans[i + 1];
            leftProduct *= nums[i];
        }
        return ans;
    }
}