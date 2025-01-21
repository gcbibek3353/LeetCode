function fibo(n: number,arr : number[]){
    if(n <= 1) return n;
    else {
        arr[n] = fibo(n-1,arr) + fibo(n-2,arr);
        return arr[n];
    }
}

function fib(n: number): number { 
   let arr = Array.from(Array(10), ()=>0);
    arr[0] = 0;
    arr[1] = 1;
    return fibo(n,arr)
};