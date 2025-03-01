function reverseBits(n: number): number {
    let ans = 0
    for(let i = 0; i < 32; i ++){
        let LSB = n & 1;
        let correctPos = 31 - i;
        ans = ans | LSB << correctPos;
        n >>= 1;
    }
    return ans >>> 0;
};