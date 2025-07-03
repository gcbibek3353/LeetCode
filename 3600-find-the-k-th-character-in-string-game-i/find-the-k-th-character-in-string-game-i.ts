function kthCharacter(k: number): string {
    function dfs(k: number, ch: string, level: number): string {
        if (level === 0) return ch;

        let half = 1 << (level - 1); // 2^(level - 1)
        if (k <= half) {
            // In the first half
            return dfs(k, ch, level - 1);
        } else {
            // In the second half: shift the result of first half
            let origChar = dfs(k - half, ch, level - 1);
            return shiftChar(origChar);
        }
    }

    function shiftChar(c: string): string {
        return c === 'z' ? 'a' : String.fromCharCode(c.charCodeAt(0) + 1);
    }

    // Determine minimum level such that 2^level >= k
    let level = 0;
    while ((1 << level) < k) level++;

    return dfs(k, 'a', level);

};