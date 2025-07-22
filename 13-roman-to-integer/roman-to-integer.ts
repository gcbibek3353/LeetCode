function romanToInt(s: string): number {
    let mp = new Map<string, number>([
        ['I', 1],
        ['V', 5],
        ['X', 10],
        ['L', 50],
        ['C', 100],
        ['D', 500],
        ['M', 1000],
    ]);
    let ans = mp.get(s.charAt(s.length - 1));

    for (let i = s.length - 2; i >= 0; i--) {
        const curVal = mp.get(s.charAt(i));
        console.log(curVal, ans);
        if (ans > curVal && s.charAt(i) !== s.charAt(i + 1)) ans -= curVal;
        else ans += curVal;
        console.log(ans);
    }
    return ans;
};