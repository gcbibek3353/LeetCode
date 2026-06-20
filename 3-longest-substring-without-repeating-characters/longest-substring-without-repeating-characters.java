class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> mp = new HashMap<>();
        int ans = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r ++) {
            char curChar = s.charAt(r);
            if(mp.containsKey(curChar)){
                l = Math.max(l , mp.get(curChar) + 1);
                // mp.put(curChar , r);
            }
            // else {
                mp.put(curChar , r );
                ans = Math.max(ans , r - l + 1);
            // }
        }
        return ans;
    }
}