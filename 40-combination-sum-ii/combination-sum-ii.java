class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        generate(candidates , target , 0 , 0);
        return ans;
    }

    private void generate(int[] candidates , int target , int curIndex , int curSum) {
        if(curSum == target){
            ans.add(new ArrayList(curList));
            return;
        }
        if(curSum > target || curIndex >= candidates.length) return;
        // Doesn't include the curIndex
        int tempIndex = curIndex;
        while(tempIndex != candidates.length - 1 && candidates[tempIndex] == candidates[tempIndex + 1]) tempIndex ++;
        generate(candidates , target , tempIndex + 1, curSum);

        // Include the curIndex
        curList.add(candidates[curIndex]);
        generate(candidates , target , curIndex + 1 , curSum + candidates[curIndex]);
        curList.remove(curList.size() - 1);
    }

}