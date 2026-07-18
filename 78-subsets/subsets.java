class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        generate(0 , ans , curList , nums);
        return ans;
    }

    private void generate(int index, List<List<Integer>> ans, List<Integer> curList, int[] nums) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(curList));
            return;
        };
        generate(index + 1 , ans ,curList, nums);
        curList.add(nums[index]);
        generate(index + 1 , ans , curList , nums);
        curList.remove(curList.size() - 1);

    }

}