function longestCommonPrefix(strs: string[]): string {

    let ans = "";

    for (let i = 0; i < strs[0].length; i++) {
        for (let j = 1; j < strs.length; j++) {
            if (strs[j].charAt(i) !== strs[0].charAt(i)) return ans;
        }
        ans += strs[0].charAt(i);
    }
    return ans;
};