class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0; 
        int j = 0;
        int ans = 0;
        Map<Character,Integer> mp = new HashMap<>();
        while(j < s.length() && i <= j) {
            if(mp.containsKey(s.charAt(j))) i = Math.max(i,mp.get(s.charAt(j)) + 1);
            int count = j - i + 1;
            ans = Math.max(ans , count);
            mp.put(s.charAt(j), j);
            j ++;
        }
        return ans;
    }
}