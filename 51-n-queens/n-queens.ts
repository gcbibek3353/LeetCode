function solveNQueens(n: number): string[][] {
    const result: string[][] = [];
    const board: string[] = Array(n).fill('.'.repeat(n));

    function isSafe1(row: number, col: number): boolean {
        let dupRow = row, dupCol = col;

        // Upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] === 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Left row
        while (col >= 0) {
            if (board[row][col] === 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Bottom-left diagonal
        while (row < n && col >= 0) {
            if (board[row][col] === 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    function solve(col: number): void {
        if (col === n) {
            result.push([...board]);
            return;
        }

        for (let row = 0; row < n; row++) {
            if (isSafe1(row, col)) {
                board[row] = board[row].slice(0, col) + 'Q' + board[row].slice(col + 1);
                solve(col + 1);
                board[row] = board[row].slice(0, col) + '.' + board[row].slice(col + 1); // backtrack
            }
        }
    }

    solve(0);
    return result;
}
