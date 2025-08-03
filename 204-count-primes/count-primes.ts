function countPrimes(n: number): number {
    if (n < 2) return 0;

    // Step 1: Create an array of size n, initialized with `true` using Array.from
    const isPrime = Array.from({ length: n }, (_, i) => i > 1);  // index 0,1 = false, rest true

    // Step 2: Sieve of Eratosthenes
    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    // Step 3: Count true values
    return isPrime.filter(Boolean).length;
}
