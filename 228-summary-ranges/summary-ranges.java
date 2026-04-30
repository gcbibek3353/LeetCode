class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        int curStarting = nums[0];
        for(int i = 0; i < nums.length; i ++) {
            if(i != 0 && nums[i] - 1 != nums[i - 1]) curStarting = nums[i];
            if(i != nums.length - 1 && nums[i + 1] - 1 == nums[i]) continue;
            else{
                if(curStarting == nums[i]) ans.add(nums[i] + "");
                else ans.add(curStarting + "->" + nums[i]);
            }
        }
        return ans;
    }
}