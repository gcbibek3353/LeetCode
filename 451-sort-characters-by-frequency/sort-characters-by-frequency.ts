function frequencySort(s: string): string {
    let mp = new Map<string, string>();

    for (let i = 0; i < s.length; i++) {
        mp.set(s.charAt(i), (mp.get(s.charAt(i)) || "") + s.charAt(i));
    }

    let ans = [];
    for (let [key, value] of mp) {
        let n = value.length;
        if (ans[n]) {
            ans[n] = ans[n] + value;
        }
        else {
            ans[n] = value;
        }
    }

    let result = "";

    for (let i = ans.length - 1; i >= 0; i--) {
        if (ans[i]) {
            result += ans[i];
        }
    }

    return result;

};