function minEatingSpeed(piles: number[], h: number): number {
    let r = Math.max(...piles);  // O(n) time 
    let l = 1;
    let ans = Infinity;

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        let time_taken = 0;
        for (let j = 0; j < piles.length; j++) {
            time_taken += Math.ceil(piles[j] / m);
        }
        if (time_taken <= h) {
            ans = Math.min(ans, m);
            r = m - 1;
        }
        else l = m + 1;
    }


    // for (let i = 1; i <= max; i++) {
    //     let time_taken = 0;
    //     for (let j = 0; j < piles.length; j++) {
    //         time_taken += Math.ceil(piles[j] / i);
    //     }
    //     if (time_taken <= h) return i;
    // }
    return ans;
};