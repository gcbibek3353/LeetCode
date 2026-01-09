class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curArr = new ArrayList<>();
        dfs(0,0,curArr,target , candidates);
        return ans;
    }
    private void dfs(int index , int curSum , List<Integer> curArr , int target , int[] candidates) {
        if(curSum == target){
            List<Integer> curAns = new ArrayList<>();
            for(int i = 0; i < curArr.size(); i ++)curAns.add(curArr.get(i));
            ans.add(curAns);
            return;
        }
        if(curSum > target || index >= candidates.length) return;
        dfs(index + 1 , curSum , curArr , target , candidates);
        curArr.add(candidates[index]);
        dfs(index , curSum + candidates[index] , curArr , target , candidates);
        curArr.remove(curArr.size() - 1);
    }
}