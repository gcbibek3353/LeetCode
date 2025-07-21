function removeOuterParentheses(s: string): string {
    let ans = new Array<string>();
    let count = 0;

    for (let char of s) {
        if (count === 0) {
            count = (char === "(") ? count + 1 : count - 1;
            continue;
        }
        else if (count === 1 && char === ")") {
            count = 0;
            continue;
        }
        else {
            ans.push(char);
            count = (char === "(") ? count + 1 : count - 1;
        }

    }
    return ans.join("");
};