class Solution { 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) { 
        Arrays.sort(candidates); 
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> curList = new ArrayList<>(); 
        
        // Start the recursive process once from index 0
        generate(candidates, target, ans, curList, 0, 0); 
        return ans; 
    } 

    private void generate(int[] candidates, int target, List<List<Integer>> ans, List<Integer> curList, int index, int curSum) { 
        if (curSum == target) { 
            ans.add(new ArrayList<>(curList)); 
            return; 
        } 
        if (curSum > target || index >= candidates.length) {
            return; 
        }

        // Loop starts directly at 'index' to handle the current element
        for (int i = index; i < candidates.length; i++) { 
            // Correct duplicate skipping within the same decision level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue; 
            }
            
            curList.add(candidates[i]); 
            // Move to 'i + 1' to avoid reusable elements 
            generate(candidates, target, ans, curList, i + 1, curSum + candidates[i]); 
            curList.remove(curList.size() - 1); 
        } 
    } 
}