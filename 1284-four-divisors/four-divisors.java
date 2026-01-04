class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int n : nums) {
            int sum = getFourDivisorSum(n);
            total += sum;
        }

        return total;
    }

    private int getFourDivisorSum(int n) {
        // Case 1: n = p^3
        int cube = (int) Math.round(Math.cbrt(n));
        if (cube * cube * cube == n && isPrime(cube)) {
            return 1 + cube + cube * cube + n;
        }

        // Case 2: n = p * q (distinct primes)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int p = i;
                int q = n / i;
                if (p != q && isPrime(p) && isPrime(q)) {
                    return 1 + p + q + n;
                }
                return 0; // more than 4 divisors
            }
        }

        return 0;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
