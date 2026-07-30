class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int count = 0;
        Map<Character , Integer> mp = new HashMap<>();
        for( r = 0; r < s.length(); r ++) {
            char curChar = s.charAt(r);
            if(mp.containsKey(curChar)){
                l = Math.max(mp.get(curChar) + 1, l);
                // mp.put(curChar , r);
            }
            
                count = Math.max(count , r - l + 1);
            
            mp.put(curChar, r);
            // System.out.printf("l : %d , r : %d , \n", l , r);
        }
        return count;
    }
}