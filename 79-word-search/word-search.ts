function exist(board: string[][], word: string): boolean {
    let ROWS = board.length;
    let COLS = board[0].length;
    let set = new Set<string>();

    const helper = (r, c, i) => {
        if (i === word.length) return true;
        if (r < 0 || c < 0 ||
            r >= ROWS || c >= COLS ||
            word[i] !== board[r][c] ||
            set.has(`${r}${c}`)) return false;

        set.add(`${r}${c}`);
        let res = 
            helper(r + 1, c, i + 1) ||
            helper(r - 1, c, i + 1) ||
            helper(r, c + 1, i + 1) ||
            helper(r, c - 1, i + 1)
        
        set.delete(`${r}${c}`);
        return res;
    }

    for(let i = 0; i < ROWS; i ++) {
        for(let j = 0; j < COLS; j ++) {
            if(helper(i , j ,0)) return true;
        }
    }
    return false;

};