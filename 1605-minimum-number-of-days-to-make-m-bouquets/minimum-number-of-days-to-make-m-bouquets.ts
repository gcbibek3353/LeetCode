function minDays(bloomDay: number[], m: number, k: number): number {
    if ((m * k) > bloomDay.length) return -1;
    let l = Math.min(...bloomDay);
    let r = Math.max(...bloomDay);
    let ans = Number.MAX_SAFE_INTEGER;

    const isPossibleWithinGivenDays = (day: number): boolean => {
        let curFlowers = 0;
        let curBouquets = 0;

        for (let i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                curFlowers++;
                if (curFlowers >= k) {
                    curBouquets++;
                    curFlowers = 0;
                }
            } else {
                curFlowers = 0;
            }
        }
        return curBouquets >= m;
    }

    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (isPossibleWithinGivenDays(m)) {
            ans = Math.min(ans, m);
            r = m - 1;
        }
        else l = m + 1;
    }
    return ans;
};