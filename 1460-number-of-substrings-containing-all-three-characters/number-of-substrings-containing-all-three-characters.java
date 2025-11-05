class Solution {
    public int numberOfSubstrings(String s) {
        int[] pos = {-1 , -1 , -1};
        int count = 0;
        for(int i = 0; i < s.length(); i ++) {
            pos[s.charAt(i) - 'a'] = i;
            if(pos[0] != -1 && pos[1] != -1 && pos[2] != -1) {
                count += Math.min(pos[0] , Math.min(pos[1], pos[2])) + 1;
            }
        }
        return count;
    }
} 