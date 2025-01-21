
   let arr = [];
    arr[0] = 0;
    arr[1] = 1;

function fib(n: number): number { 
     if(n <= 1) return n;
     else{
        if(arr[n]) return arr[n];
        else{
            arr[n] = fib(n-1) + fib(n-2);
            return arr[n];
        }
     }
    return fib(n);
};