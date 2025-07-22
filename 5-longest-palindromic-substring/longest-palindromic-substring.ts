function longestPalindrome(s: string): string {
    let maxStr = "";

    const expandFromCenter = (l: number, r: number): string => {
        while (l >= 0 && r < s.length && s.charAt(l) === s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    for (let i = 0; i < s.length; i++) {
        let odd = expandFromCenter(i, i);
        let even = expandFromCenter(i, i + 1);

        if (odd.length > maxStr.length) {
            maxStr = odd;
        }
        if (even.length > maxStr.length) {
            maxStr = even;
        }
    }

    return maxStr;

};