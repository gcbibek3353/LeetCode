class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {
            Character curChar = s.charAt(i);
            if(curChar == '(') st.push(curChar);
            else {
                if(st.size() > 0 && st.peek() == '(') st.pop();
                else st.push(curChar);
            }
        }

        return st.size();
    }
}