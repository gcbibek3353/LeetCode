class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("(", 1, n);
        return ans;
    }

    private void generate(String curStr, int openCount , int n) {
        int m = curStr.length();
        if(m == n * 2){
            ans.add(curStr);
            return;
        }
        int closedCount = m - openCount;
        if(openCount < n) generate(curStr + "(" , openCount + 1 , n);
        if(closedCount < n && closedCount < openCount) generate(curStr + ")" , openCount , n);
    }
}