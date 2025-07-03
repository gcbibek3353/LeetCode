function fib(n: number): number {
    let arr = [0, 1];

    if (n === 0) return 0;
    if (arr[n]) return arr[n];
    return arr[n] = (fib(n - 1) + fib(n - 2));

};