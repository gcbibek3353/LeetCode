class Solution {
    Integer[][][] dp;
    int MOD = 1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2];
        int startingWithZero = count(zero , one , false,limit);
        int startingWithOne = count(zero , one , true , limit);
        return (startingWithZero + startingWithOne) % MOD;
    }

    private int count(int zeroLeft , int oneLeft , boolean onesTurn , int limit) {
        if(zeroLeft == 0 && oneLeft == 0) return 1;
        int correspondingDigit = onesTurn ? 1 : 0;
        if(dp[zeroLeft][oneLeft][correspondingDigit] != null) return dp[zeroLeft][oneLeft][correspondingDigit];

        long result = 0;
        if(onesTurn){
            for(int i = 1; i <= Math.min(limit , oneLeft); i ++){   
                result += count(zeroLeft , oneLeft - i , false , limit);
            }
        }
        else {
            for(int i = 1; i <= Math.min(limit , zeroLeft); i ++){   
                result += count(zeroLeft - i , oneLeft , true , limit);
            }
        }
        result = result % MOD;
        dp[zeroLeft][oneLeft][correspondingDigit] = (int)result;
        return dp[zeroLeft][oneLeft][correspondingDigit];
    }
}