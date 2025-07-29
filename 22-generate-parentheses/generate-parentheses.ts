function generateParenthesis(n: number): string[] {
    const ans = [];

    const dfs = (oc: number, cc: number, cur: string): void => {
        if (oc === cc && cur.length === n * 2) {
            ans.push(cur);
            return;
        }
        if (oc < n) {
            
            dfs(oc + 1, cc, cur + "(");
        }
        if (cc < oc) {
            dfs(oc, cc + 1, cur + ")");
        }
    }
    dfs(0, 0, "");
    return ans;
};