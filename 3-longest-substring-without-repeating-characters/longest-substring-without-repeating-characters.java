class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0; 
        int ans = 0;
        Map<Character , Integer> mp = new HashMap<>();
        while(r < s.length()) {
            Character curChar = s.charAt(r);
            if(mp.containsKey(curChar)) l = Math.max(mp.get(curChar) + 1 , l);
            mp.put(curChar,r);
            int curCount = r - l + 1;
            ans = Math.max(ans , curCount);
            r ++;
        }
        return ans;
    }
}