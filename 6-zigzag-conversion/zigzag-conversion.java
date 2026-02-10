class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] words = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            words[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {

            // down
            for (int j = 0; j < numRows && i < s.length(); j++) {
                words[j].append(s.charAt(i++));
            }

            // up (skip first and last row)
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                words[j].append(s.charAt(i++));
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : words) {
            res.append(row);
        }

        return res.toString();
    }
}
