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


        // pick
        curList.add(nums[curIndex]);
        generate(nums , curIndex + 1);
        curList.remove(curList.size() - 1);
        // don't pick
        int tempIndex = curIndex;
        while(tempIndex != nums.length - 1 && nums[tempIndex] == nums[tempIndex + 1]) tempIndex ++;
        generate(nums , tempIndex + 1);
    }
}