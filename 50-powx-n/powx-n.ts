function findPow(x: number, n: number): number {
    if(n === 0) return 1;
    if(n === 1) return x;
    else if(n%2=== 0) return myPow(x*x,n/2);
    else return x * myPow(x,n-1);
}

function myPow(x: number, n: number): number {
    let sign = (n < 0) ? -1 : 1;
    const ans = findPow(x,Math.abs(n));
    return (sign === -1) ? 1/ans : ans;
};