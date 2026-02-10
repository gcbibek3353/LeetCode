class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> odds = new HashSet<>();
            Set<Integer> evens = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (odds.contains(nums[j]) || evens.contains(nums[j])){
                     if (odds.size() == evens.size())
                    ans = Math.max(ans, j - i + 1);
                    continue;
                }
                if (nums[j] % 2 == 0)
                    evens.add(nums[j]);
                else
                    odds.add(nums[j]);
                if (odds.size() == evens.size())
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}