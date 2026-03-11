class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;

        int diff1 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < doubled.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';

            if (doubled.charAt(i) != expected1) diff1++;

            if (i >= n) {
                char prevExpected1 = ((i - n) % 2 == 0) ? '0' : '1';

                if (doubled.charAt(i - n) != prevExpected1) diff1--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, n - diff1));
            }
        }

        return ans;
    }
}