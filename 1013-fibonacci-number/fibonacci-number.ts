// let arr = [];
function fib(n: number): number {
    if(n === 0) return 0;
    if(n === 1) return 1;
    // if(arr[n]) return arr[n];
    // else{
    // arr[n] = 
    return fib(n-1) + fib(n-2);
    // } 
};