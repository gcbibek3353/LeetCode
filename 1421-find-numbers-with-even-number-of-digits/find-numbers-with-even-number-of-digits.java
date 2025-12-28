class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            String s = Integer.toString(num);
            ans += (s.length() % 2 == 0) ? 1 : 0; 
        }
        return ans;
    }
}