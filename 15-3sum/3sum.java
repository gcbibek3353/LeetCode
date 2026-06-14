class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curTarget = 0 - nums[i];
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            twoSum(nums, curTarget, i, nums.length - 1, ans);
        }
        return ans;
    }

    private void twoSum(int[] nums, int target, int l, int right, List<List<Integer>> ans) {
    int left = l + 1;

    while (left < right) {
        int sum = nums[left] + nums[right];

        if (sum < target) {
            left++;
        } else if (sum > target) {
            right--;
        } else {
            ans.add(Arrays.asList(nums[l], nums[left], nums[right]));

            left++;
            right--;

            while (left < right && nums[left] == nums[left - 1])
                left++;

            while (left < right && nums[right] == nums[right + 1])
                right--;
        }
    }
}

}