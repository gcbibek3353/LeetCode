class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < nums.length; i ++) st.add(nums[i]);
        int num = k;
        for(int i = 0; i < nums.length; i ++) {
            if(!st.contains(num)) return num;
            num += k;
        }
        return num;
    }
}