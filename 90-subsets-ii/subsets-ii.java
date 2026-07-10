class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generate(nums , 0);
        return ans;
    }
    private void generate(int[] nums , int curIndex){
        if(curIndex == nums.length){
            ans.add(new ArrayList(curList));
            return;
        }

        curList.add(nums[curIndex]);
        generate(nums , curIndex + 1);
        curList.remove(curList.size() - 1);

        while(curIndex < nums.length - 1 && nums[curIndex] == nums[curIndex + 1]) curIndex ++;
        generate(nums , curIndex + 1);
    }

}