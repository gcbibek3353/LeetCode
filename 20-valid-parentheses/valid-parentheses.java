class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put('(', ')');
        mp.put('{', '}');
        mp.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i)))
                st.push(s.charAt(i));
            else {
                if(st.isEmpty()) return false;
                if (s.charAt(i) != mp.get(st.peek()))
                    return false;
                else
                    st.pop();
            }
        }
        return st.isEmpty();
    }
}