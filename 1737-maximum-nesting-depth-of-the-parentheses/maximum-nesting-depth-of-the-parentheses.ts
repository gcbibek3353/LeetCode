function maxDepth(s: string): number {
    let count = 0;
    let ans = 0;
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === "(") {
            count++;
            ans = Math.max(ans, count);
        }
        else if (s.charAt(i) === ")") count--;
    }
    return ans;
};