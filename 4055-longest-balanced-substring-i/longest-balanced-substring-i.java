class Solution {
    public int longestBalanced(String s) {
        int[] freqTable = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(freqTable, 0);
            for (int j = i; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';
                freqTable[c]++;
                boolean isBalanced = true;
                for (int x : freqTable) {
                    if (x > 0 && x != freqTable[c]) {
                        isBalanced = false;
                        break;
                    }
                }
                if (isBalanced)
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}