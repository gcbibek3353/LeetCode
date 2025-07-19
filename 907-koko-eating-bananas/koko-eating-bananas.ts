function minEatingSpeed(piles: number[], h: number): number {
    let l = 1;
    let r = Math.max(...piles);
    let ans = Infinity;

    function getHoursGivenRate(r: number): number {
        let hours = 0;
        for (let i = 0; i < piles.length; i++) {
            hours += Math.ceil(piles[i] / r);
        }
        return hours;
    }

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        let hours = getHoursGivenRate(m);
        if (hours <= h) {
            ans = Math.min(ans, m);
            r = m - 1;
        }
        else l = m + 1;
    }
    return ans;

};