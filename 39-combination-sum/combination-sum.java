class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curArr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates , 0 , 0 , target);
        return ans;
    }

    private void dfs(int[] candidates , int index , int curSum , int target) {
        if(curSum == target) {
            ans.add(new ArrayList<>(curArr));
            return;
        }
        if(curSum > target || index >= candidates.length) return;
        curArr.add(candidates[index]);
        dfs(candidates , index , curSum + candidates[index],target);
        curArr.remove(curArr.size() - 1);
        dfs(candidates , index + 1 , curSum , target);
    }
}