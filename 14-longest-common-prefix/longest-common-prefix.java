class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i ++) {
            for(int j = 1; j < strs.length; j ++) {
                if(i >= strs[j].length()) return ans.toString();
                if(strs[j].charAt(i) != strs[0].charAt(i)) return ans.toString();
            }
            ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
}