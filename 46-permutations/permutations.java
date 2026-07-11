class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        generate(nums , visited);
        return ans;
    }
    private void generate(int[] nums , boolean[] visited) {
        if(curList.size() == nums.length){
            ans.add(new ArrayList(curList));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                curList.add(nums[i]);
                generate(nums , visited);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }
}