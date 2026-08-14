class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        int l = 0;
        Map<Character , Integer> mp = new HashMap<>();
        for(int r = 0; r < s.length(); r ++) {
            char curChar = s.charAt(r);
            if(mp.containsKey(curChar)){
                int freq = mp.get(curChar);
                if(freq == 2){
                    while(l < r && s.charAt(l) != curChar){
                        mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                    l ++;
                    } 
                    l ++;
                }
                else{
                mp.put(curChar , freq + 1);
                }
            }
            else{
                mp.put(curChar , 1);
            }
            System.out.printf("l : %d , r : %d \n", l , r);
            max = Math.max(max , r - l + 1);
        }
        return max;
    }
}