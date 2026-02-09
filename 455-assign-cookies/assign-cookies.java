class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while(l < s.length && r < g.length) {
            if(s[l] >= g[r]) {
                count ++;
                r ++;
            }
            l ++;
        }
        return count;
    }
}