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

    for(let i = s.length - 2; i >= 0; i--) {
        if(mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
            ans -= mp.get(s.charAt(i));
        }
        else ans += mp.get(s.charAt(i));
    }
    return ans;
};