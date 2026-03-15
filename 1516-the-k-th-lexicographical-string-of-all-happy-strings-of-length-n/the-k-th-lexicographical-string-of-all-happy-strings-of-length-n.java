class Solution {
    int n;
    int k;
    int count;
    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        this.count = 0;
        return dfs("");
    }

    private String dfs(String s) {
        if(s.length() == n){
            count ++;
            return (count == k) ? s : "";
        }
        if(s.length() == 0){
            String aAns = dfs("a");
            String bAns = dfs("b");
            String cAns = dfs("c");
            return aAns != "" ? aAns : bAns != "" ? bAns : cAns;
        }
        else {
            char curChar = s.charAt(s.length() - 1);
            if(curChar == 'a'){
                String bAns = dfs(s + "b");
                String cAns = dfs(s + "c");
                return bAns != "" ? bAns : cAns;
            }
            else if (curChar == 'b') {
                String aAns = dfs(s + "a");
                String cAns = dfs(s + "c");
                return aAns != "" ? aAns : cAns;
            }
            else{
                String aAns = dfs(s + "a");
                String bAns = dfs(s + "b");
                return bAns != "" ? bAns : aAns;
            }
        }
    }
}