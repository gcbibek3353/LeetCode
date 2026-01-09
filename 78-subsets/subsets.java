class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curArr = new ArrayList<>();
        generate(curArr , nums , 0 , ans);
        return ans;
    }
    private void generate(List<Integer> curArr , int[] nums , int n , List<List<Integer>> ans){
        if(nums.length == n){
            List<Integer> curAns = new ArrayList<>();
            for(int i = 0; i < curArr.size(); i ++) curAns.add(curArr.get(i));
            ans.add(curAns);
            return;
        }

        generate(curArr , nums , n + 1 , ans);
        curArr.add(nums[n]);
        generate(curArr ,nums,n + 1 , ans);
        curArr.remove(curArr.size() - 1);;
    }
}