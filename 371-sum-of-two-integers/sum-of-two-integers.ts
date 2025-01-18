function getSum(a: number, b: number): number {
    let carry = 0;
    while(b !== 0){
        carry = a & b;
        a = a ^ b;
        b = carry << 1;
    }

    return a;
};