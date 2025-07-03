    let arr = [0, 1, 1];
function tribonacci(n: number): number {
    if (n === 0) return 0;
    if (arr[n]) return arr[n];
    return arr[n] = (tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
};