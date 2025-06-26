function tribonacci(n: number): number {
    let memo = [0];
    function tribo(n: number): number {
        if(memo[n]) return memo[n];
        if (n === 0) return 0;
        if (n === 1) return 1;
        if (n === 2) return 1;
        return memo[n] = tribo(n - 1) + tribo(n - 2) + tribo(n - 3);
    }
    return tribo(n);
};