class Solution {
    public boolean check(int[] nums) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < nums.length; i ++) {
            if((nums[i] < min) || (nums[i] == min && nums[i] != nums[i - 1])) {
                min = nums[i];
                minIndex = i;
            }
        }

        for(int i = 0; i < nums.length - 1; i ++) {
            int curIndex = i + minIndex;
            if(nums[curIndex % n] > nums[(curIndex + 1) % n]) return false;
        }
        return true;
    }
}