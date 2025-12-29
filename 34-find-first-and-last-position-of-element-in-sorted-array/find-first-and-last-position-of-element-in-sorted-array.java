class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int[] ans = new int[2];
        int l = 0;
        int r = nums.length - 1;
        int startIndex = -1;
        int endIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] == target) {
                endIndex = mid;
                l = mid + 1;
            } else
                l = mid + 1;
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] == target) {
                startIndex = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }

        ans[0] = startIndex;
        ans[1] = endIndex;
        return ans;
    }
}