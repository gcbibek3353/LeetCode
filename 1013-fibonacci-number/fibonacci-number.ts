function fib(n: number): number { 
    let n0 = 0;
    let n1 = 1;
    if(n === 0) return n0;
    if(n === 1) return n1;
    let n2 = 0;
    for(let i = 2; i <= n; i ++){
        n2 = n0 + n1;
        n0 = n1;
        n1 = n2;
        console.log(n0 , n1 , n2 , i)
    }     
    return n2;
};