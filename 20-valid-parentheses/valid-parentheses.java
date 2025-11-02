class Solution {
    public boolean isValid(String s) {
        Map<Character , Character> mp = new HashMap<>();
        mp.put('(',')');
        mp.put('{','}');
        mp.put('[',']');
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {
            char curChar = s.charAt(i);
            if(!mp.containsKey(curChar)){
                if(st.isEmpty()) return false;
                if(curChar == mp.get(st.peek())) st.pop();
                else return false;
            }
            else st.push(curChar);
        }

        return st.isEmpty();
    }
}