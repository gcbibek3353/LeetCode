function countGoodNumbers(n: number): number {
    const mod: bigint = 1000000007n;

    // use fast exponentiation to calculate x^y % mod
    function quickmul(x: bigint, y: bigint): bigint {
        let ret: bigint = 1n;
        let mul: bigint = x;
        while (y > 0n) {
            if (y % 2n === 1n) {
                ret = (ret * mul) % mod;
            }
            mul = (mul * mul) % mod;
            y = y / 2n;
        }
        return ret;
    }

    return Number(
        (quickmul(5n, BigInt(n + 1) / 2n) * quickmul(4n, BigInt(n) / 2n)) % mod,
    );
}