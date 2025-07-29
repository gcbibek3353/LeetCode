function letterCombinations(digits: string): string[] {
    let mp = new Map<number, string>([
        [2, "abc"],
        [3, "def"],
        [4, "ghi"],
        [5, "jkl"],
        [6, "mno"],
        [7, "pqrs"],
        [8, "tuv"],
        [9, "wxyz"],
    ])

    let ans = [];

    const helper = (count, curStr) => {
        if (count === digits.length) {
            ans.push(curStr);
            return;
        }
        let str = mp.get(parseInt(digits.charAt(count)));
        for (let i = 0; i < str.length; i++) {
            helper(count + 1, curStr + str.charAt(i));
        }
    }
    if (digits) helper(0, "");
    return ans;
};