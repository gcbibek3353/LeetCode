function isPowerOfTwo(n: number): boolean {
    if(n <= 0) return false;
    if(n === 1) return true;
    while(n > 1){
        n = n / 2;
        if(n === 1) return true;
    }
    return false;
};
