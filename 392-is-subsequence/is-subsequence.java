class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;
        int sp = 0;
        for(int i = 0; i < t.length(); i ++) {
            if(sp<s.length() && t.charAt(i) == s.charAt(sp)) sp ++;
        }
        return sp == s.length();
    }
}