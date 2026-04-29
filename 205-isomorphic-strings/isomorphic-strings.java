class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character , Character> sTot = new HashMap<>();
        Map<Character , Character> tTos = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            Character curSChar = s.charAt(i);
            Character curTChar = t.charAt(i);
            if(sTot.containsKey(curSChar)){
                if(curTChar != sTot.get(curSChar)) return false;
            }
            if(tTos.containsKey(curTChar)){
                if(curSChar != tTos.get(curTChar)) return false;
            }
            sTot.put(curSChar,curTChar);
            tTos.put(curTChar,curSChar);
        }

        return true;

    }
}