class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i --;
        if(i < 0){ 
            reverse(nums , 0);
            return;
        }
        int j = nums.length - 1;
        while(nums[i] >= nums[j]) j --;
        swap(nums , i , j);
        reverse(nums , i + 1);
    }
    private void swap(int[] nums , int ind1 , int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
    private void reverse(int[] nums , int startInd) {
        int endInd = nums.length - 1;
        while(startInd < endInd) {
            this.swap(nums,startInd,endInd);
            startInd ++;
            endInd --;
        }
    }
}