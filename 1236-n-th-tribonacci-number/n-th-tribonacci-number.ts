function tribonacci(n: number): number {
    let n0 = 0;
    let n1 = 1;
    let n2 = 1;
    let n3 = 0;
    if (n === 0) return n0;
    if (n === 1) return n1;
    if (n === 2) return n2;
    for(let i = 3; i <= n; i ++){
        n3 = n0 + n1 + n2;
        n0 = n1;
        n1 = n2;
        n2 = n3;
    }
    return n3;
};