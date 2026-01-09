class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curArr = new ArrayList<>();
        dfs(0,curArr , 0 , target , candidates);
        return ans;
    }

    private void dfs(int index , List<Integer> curArr , int curSum , int target , int[] candidates) {
        if(curSum == target){
            List<Integer> curAns = new ArrayList<>();
            for(int i = 0; i < curArr.size(); i ++) curAns.add(curArr.get(i));
            ans.add(curAns);
            return;
        }
        if(index >= candidates.length || curSum > target) return;
        curArr.add(candidates[index]);
        dfs(index + 1 , curArr , curSum + candidates[index], target , candidates);
        curArr.remove(curArr.size() - 1);
        while(index < candidates.length - 1 && candidates[index] == candidates[index + 1]) index ++;
        dfs(index + 1 , curArr, curSum , target , candidates);
    }
}