class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> mp = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for(int r = 0; r < s.length(); r ++) {
            char curChar = s.charAt(r);
            if(mp.containsKey(curChar)){
                int prevIndex = mp.get(curChar);
                l = Math.max(l, prevIndex + 1);
            }
            mp.put(curChar , r);
            int curLen = r - l + 1;
            maxLen = Math.max(maxLen , curLen);
        }
        return maxLen;
    }
}