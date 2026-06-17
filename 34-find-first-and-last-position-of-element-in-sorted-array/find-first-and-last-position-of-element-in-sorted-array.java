class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurance = findFirstOrLastOccurance(nums , target , true);
        int lastOccurance = findFirstOrLastOccurance(nums , target , false);
        return new int[]{firstOccurance,lastOccurance};
    }

    private int findFirstOrLastOccurance(int[] nums , int target, boolean isFindingFirstOccurance){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] < target) l = m + 1;
            else if (nums[m] == target){
                ans = m;
                if(isFindingFirstOccurance) r = m - 1;
                else l = m + 1;
            }
            else r = m - 1;
        }
        return ans;
    }
}