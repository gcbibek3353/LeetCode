class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n < 4 && n >= 2) return ans;
        char[][] board = new char[n][n];
        for(int i = 0; i <n; i ++){
            for(int j = 0; j < n; j ++) board[i][j] = '.';
        }
        solve(0 , board, n);
        return ans;
    }

    private void solve(int col , char[][] board , int n){
        if(col == n){
            construct(board);
            return;
        }
        for(int i = 0; i < n; i ++) {
            if(isSafe(i , col , board)){
                board[i][col] = 'Q';
                solve(col + 1, board,n);
                board[i][col] = '.';
            }
        }
    }

    private boolean isSafe(int row , int col , char[][] board){
        int n = board.length;
        int r = row;
        int c = col;
        // check on top left
        while(r >= 0 && c >= 0) {
            if(board[r][c] == 'Q') return false;
            r --;
            c --;
        }
        r = row;
        c = col;
        while(c >= 0){
            if(board[r][c] == 'Q') return false;
            c --;
        }
        c = col;
        while(r < n && c >= 0){
            if(board[r][c] == 'Q') return false;
            r ++;
            c --;
        }
        return true;
    }

    private void construct(char[][] board) {
        List<String> curList = new ArrayList<>();
        for(int i = 0; i < board.length; i ++){
            String curStr = "";
            for(int j = 0; j < board[0].length; j ++) {
                curStr += board[i][j];
            }
            curList.add(curStr);
        }
        ans.add(curList);
    }
}