class Solution {
    public String removeStars(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i ++) {
            char curChar = s.charAt(i);
            if(curChar != '*') st.push(curChar);
            else{
                if(!st.isEmpty()) st.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.insert(0,st.pop());
        }
        return ans.toString();
    }
}