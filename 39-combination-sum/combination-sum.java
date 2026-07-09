class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generate(0 , 0 , candidates , target);
        return ans;
    }

    private void generate(int curSum , int curIndex, int[] candidates , int target) {
        if(curSum > target || curIndex == candidates.length) return;
        if(curSum == target){
            List<Integer> curAns = new ArrayList<>();
            for(int i = 0; i < curList.size(); i ++) curAns.add(curList.get(i));
            ans.add(curAns);
            return;
        }
        curList.add(candidates[curIndex]);
        generate(curSum + candidates[curIndex], curIndex , candidates , target);
        curList.remove(curList.size() - 1);
        generate(curSum , curIndex + 1 , candidates , target);
    }
}