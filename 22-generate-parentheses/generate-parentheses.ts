function generateParenthesis(n: number): string[] {
    let ans = [];

    const dfs = (open: number, closed: number, curStr: string): void => {
        if (open === closed && open + closed === 2 * n) {
            ans.push(curStr);
            return;
        }

        if (open < n) dfs(open + 1, closed, curStr + "(");
        if (closed < open) dfs(open, closed + 1, curStr + ")");
    }
    dfs(0, 0, "");
    return ans;
};