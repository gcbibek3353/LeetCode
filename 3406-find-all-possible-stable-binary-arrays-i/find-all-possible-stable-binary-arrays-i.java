class Solution {
    private Integer[][][] dp;
    private static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2];
        int countStartingWithZero = solve(zero , one , true , limit);
        int countStartingWithOne = solve(zero , one , false , limit);
        return (countStartingWithZero + countStartingWithOne) % MOD;
    }
    private int solve(int zerosLeft , int onesLeft , boolean lastWasOne , int limit) {
         if(onesLeft == 0 && zerosLeft == 0) return 1;

        int last = lastWasOne ? 1 : 0;
        if(dp[zerosLeft][onesLeft][last] != null) {
            return dp[zerosLeft][onesLeft][last];
        }

        long result = 0;

        if(lastWasOne){
            for(int len = 1; len <= Math.min(zerosLeft , limit); len++){
                result += solve(zerosLeft - len , onesLeft , false , limit);
                result %= MOD;
            }
        }
        else{
            for(int len = 1; len <= Math.min(onesLeft , limit); len++){
                result += solve(zerosLeft , onesLeft - len , true , limit); // fixed
                result %= MOD;
            }
        }

        dp[zerosLeft][onesLeft][last] = (int) result;
        return dp[zerosLeft][onesLeft][last];
    }
}