class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        return neededCoins(coins, amount, dp);
    }

    private int neededCoins(int[] coins, int remaining, Integer[] dp) {
        if (remaining == 0) return 0;
        if (remaining < 0) return -1;

        if (dp[remaining] != null) return dp[remaining];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = neededCoins(coins, remaining - coin, dp);

            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        dp[remaining] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return dp[remaining];
    }
}