class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        int cur1Count = 0;
        int i = 0;

        for(int j = 0; j < s.length(); j ++) {
            if(s.charAt(j) == '1') cur1Count ++;
            while(cur1Count >= k) {
                String curr = s.substring(i, j + 1);
                int len = j - i + 1;
            if (len < minLen ||
                (len == minLen && curr.compareTo(ans) < 0)) {
                minLen = len;
                ans = curr;
            }
                if(s.charAt(i) == '1') cur1Count --;
                i ++;
            }
        }
        return ans;
    }
}