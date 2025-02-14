function mySqrt(x: number): number {
    if(x === 0 || x === 1) return x;
    for(let i = 0; i < x; i ++){
        if(i * i <= x && ((i + 1) * (i + 1) > x)) return i;
    }
};