function fib(n: number): number {
    if(n === 0) return 0;
    if(n === 1) return 1;
    let n1 = 0;
    let n2 = 1;
    for(let i = 2; i <= n ; i ++){
        let sum = n1 + n2;
        n1 = n2;
        n2 = sum;
    }
    return n2;
};