class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        generate(nums);
        return ans;
    }
    private void generate(int[] nums) {
        if(curList.size() == nums.length){
            ans.add(new ArrayList(curList));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(!visited[i]){
                curList.add(nums[i]);
                visited[i] = true;
                generate(nums);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            } 
        }
    }
}