class Solution {
    Integer[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        memo = new Integer[s1.length()][s2.length()];
        return dfs(s1, s2, 0, 0);
    }

    private int dfs(String s1, String s2, int i, int j) {
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) sum += s2.charAt(k);
            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) sum += s1.charAt(k);
            return sum;
        }

        if (memo[i][j] != null) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dfs(s1, s2, i + 1, j + 1);
        } else {
            int deleteS1 = s1.charAt(i) + dfs(s1, s2, i + 1, j);
            int deleteS2 = s2.charAt(j) + dfs(s1, s2, i, j + 1);
            memo[i][j] = Math.min(deleteS1, deleteS2);
        }

        return memo[i][j];
    }
}
