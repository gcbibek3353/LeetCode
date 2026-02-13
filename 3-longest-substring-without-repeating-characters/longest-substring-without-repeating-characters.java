class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int ans = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            Character curChar = s.charAt(j);
            if (mp.containsKey(curChar))
                i = Math.max(i, mp.get(curChar) + 1);
            ans = Math.max(ans, j - i + 1);
            mp.put(curChar, j);
        }
        return ans;
    }
}