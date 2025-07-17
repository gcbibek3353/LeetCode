function findKthPositive(arr: number[], k: number): number {
   
    let l = 0;
    let r = arr.length - 1;

    while( l <= r ) {
        let m = Math.floor( ( l + r) / 2);
        if((arr[m] - (m + 1)) < k) l = m + 1;
        else r = m - 1;
    }


    if (r === -1) return k;

    return arr[r] + ( k - (arr[r] - (r + 1)));
    //     7      +   5  - (7  -  4)
};