class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 
                        50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", 
                            "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (num == 0) break;
            int count = num / values[i];
            num -= count * values[i];
            while (count-- > 0) {
                res.append(symbols[i]);
            }
        }

        return res.toString();
    }
}
