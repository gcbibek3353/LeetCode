class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(m == 0){
                if(nums[m] > nums[m + 1]) return 0;
                else l = m + 1;
            }
            else if( m == nums.length - 1){
                if(nums[m] > nums[m - 1]) return m;
                else r = m - 1;
            }
            else{
                if(nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) return m;
                else if (nums[m] > nums[m - 1] && nums[m] < nums[m + 1]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}