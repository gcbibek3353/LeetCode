class Solution {
    public int numDecodings(String s) {
        int[] computedValues = new int[s.length()];
        Arrays.fill(computedValues, -1);
        return waysToDecode(s, 0, computedValues);
    }

    private int waysToDecode(String s, int n, int[] computedValues) {
        if (n >= s.length())
            return 1;
        if(computedValues[n] != -1) return computedValues[n];
        if (s.charAt(n) == '0')
            return 0;

        int keepingSingleDigitAns = waysToDecode(s, n + 1, computedValues);

        int keepingMultipleDigitAns = 0;

        if (n + 1 < s.length()) {
            int twoDigitNumber = (s.charAt(n) - '0') * 10 + (s.charAt(n + 1) - '0');

            if (twoDigitNumber >= 10 && twoDigitNumber <= 26) {
                keepingMultipleDigitAns = waysToDecode(s, n + 2, computedValues);
            }
        }

        return computedValues[n] = keepingSingleDigitAns + keepingMultipleDigitAns;
    }
}