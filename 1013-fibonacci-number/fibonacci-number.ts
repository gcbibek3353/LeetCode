function fib(n: number): number { 
    let arr = [0];
    function fibbo(n : number) : number {
        if(n === 0) return 0;
        else if(n === 1) return 1;

        if(arr[n]) return arr[n];
        else return fibbo(n-2) + fibbo(n - 1);
    }
    return fibbo(n);
};