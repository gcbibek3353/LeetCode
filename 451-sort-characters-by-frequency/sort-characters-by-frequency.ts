function frequencySort(s: string): string {
    let mp = new Map<string, string>();

    for (let i = 0; i < s.length; i++) mp.set(s.charAt(i),(mp.get(s.charAt(i)) || "") + s.charAt(i));

    let result = [];

    for (let [key, value] of mp) {
        if (result[value.length]) result[value.length] += value;
        else result[value.length] = value;
    }

    let ans = "";

    for (let i = result.length; i >= 0; i--) if (result[i]) ans += result[i];

    return ans;

};