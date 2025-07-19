function findKthPositive(arr: number[], k: number): number {
    let l = 0;
    let r = arr.length - 1;
    const getNoOfMissing = (i: number): number => (arr[i] - (i + 1));
    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        const missing = getNoOfMissing(m);
        if (missing < k) l = m + 1;
        else r = m - 1;
    }
    if (r === -1) return k;
    return (arr[r] + k - getNoOfMissing(r));

};