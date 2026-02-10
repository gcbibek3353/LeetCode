class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++) {
            if(i == 0 || nums[i] != nums[i - 1])
            twoSum(nums , i + 1 , nums.length - 1, nums[i]);
        }
        return ans;
    }
    private void twoSum(int[] nums , int l ,int r ,int target) {
        while(l < r) {
            int curSum = nums[l] + nums[r];
            if(curSum == -target) {
                List<Integer> curAns = new ArrayList<>();
                curAns.add(nums[l]);
                curAns.add(nums[r]);
                curAns.add(target);
                ans.add(curAns);
                l ++;
                r --;
                while(l < r && nums[l] == nums[l - 1]) l ++;
                while(l < r && nums[r] == nums[r + 1]) r --;
            }
            else if (curSum < -target) l ++;
            else r --;
        }
    }
}