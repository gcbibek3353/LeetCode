class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generate(candidates ,  target ,  0 , 0);
        return ans;
    }
    private void generate(int[] candidates , int target , int curSum ,int index){
        if(curSum == target){
            ans.add(new ArrayList(curList));
            return;
        }
        if(curSum > target || index == candidates.length) return;
        for(int i = index; i < candidates.length; i ++) {
            curList.add(candidates[i]);
            generate(candidates , target , curSum + candidates[i] , i);
            curList.remove(curList.size() - 1);
        }
    }
}