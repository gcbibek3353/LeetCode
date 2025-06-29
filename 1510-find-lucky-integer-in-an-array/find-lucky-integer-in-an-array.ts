function findLucky(arr: number[]): number {
    const mp = new Map<number, number>();

    for (let i = 0; i < arr.length; i++) {
        if (mp.has(arr[i])) {
            mp.set(arr[i], mp.get(arr[i]) + 1);
        }
        else {
            mp.set(arr[i], 1);
        }
    }

    let ans = -1;
    for (let [key, value] of mp.entries()) {
        if (key === value) ans = Math.max(ans, key);
    }
    return ans;
};