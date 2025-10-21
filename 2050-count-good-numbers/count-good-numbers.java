class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // ceil(n/2)
        long oddPositions = n / 2;        // floor(n/2)

        long part1 = modPow(5, evenPositions, MOD);
        long part2 = modPow(4, oddPositions, MOD);

        return (int)((part1 * part2) % MOD);
    }

    // Fast modular exponentiation
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // if exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // divide exp by 2
        }

        return result;
    }
}
