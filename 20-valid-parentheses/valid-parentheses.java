class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put('(', ')');
        mp.put('{', '}');
        mp.put('[', ']');
    
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {
            Character curChar = s.charAt(i);
            if(mp.containsKey(curChar)) st.push(curChar);
            else{
                if(st.size() == 0) return false;
                Character topChar = st.pop();
                if(mp.get(topChar) != curChar) return false;
            }
        }
        return st.size() == 0;
    }
}