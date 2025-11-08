class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, ans);
            }
        }
        return ans;
    }

    private void twoSum(int[] nums, int start, List<List<Integer>> ans) {
        int target = -nums[start];
        int l = start + 1;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                List<Integer> curAns = new ArrayList<>();
                curAns.add(nums[start]);
                curAns.add(nums[l]);
                curAns.add(nums[r]);
                ans.add(curAns);
                l++;
                r --;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
                while (l < r && nums[r] == nums[r + 1])
                    r--;
            } else if (nums[l] + nums[r] < target)
                l++;
            else
                r--;
        }
    }
}