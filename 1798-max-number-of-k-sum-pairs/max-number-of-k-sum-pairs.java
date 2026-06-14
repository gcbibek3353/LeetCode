class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int count = 0;
        int r = nums.length - 1;
        while(l < r) {
            int curSum = nums[l] + nums[r];
            if(curSum > k) r --;
            else if (curSum < k) l ++;
            else{
                count ++;
                l ++;
                r --;
            }
        }
        return count;
    }
}