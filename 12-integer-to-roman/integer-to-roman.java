class Solution {
    public String intToRoman(int num) {
        int[] tokens = {1000, 900, 500, 400, 100, 90, 
                        50, 40, 10, 9, 5, 4, 1};
        String[] values = {"M", "CM", "D", "CD", "C", "XC", 
                            "L", "XL", "X", "IX", "V", "IV", "I"};
        String ans = "";
        for(int i = 0; i < tokens.length; i ++ ) {
            if(num == 0) break;
            int count = num / tokens[i];
            num -= count * tokens[i];
            while(count > 0) {
                ans += values[i];
                count --;
            }
        }
        return ans;
    }
}
