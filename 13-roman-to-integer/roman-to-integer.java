class Solution {
    public int romanToInt(String s) {
        Map<Character , Integer> mp = new HashMap<>();
        int ans = 0;
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int n = s.length();

        for(int i = n - 1; i >= 0; i --) {
            int curCharValue = mp.get(s.charAt(i));
            if(i == n - 1) ans += curCharValue;
            else {
                int nextCharValue = mp.get(s.charAt(i + 1));
                if(curCharValue < nextCharValue) ans -= curCharValue;
                else ans += curCharValue;
            }
        }
        return ans;
    }
}