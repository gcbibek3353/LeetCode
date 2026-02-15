class Solution {
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] nextState = new int[r][c];

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++) {
                int count = countLive(board , i , j);
                if(board[i][j] == 0) nextState[i][j] = (count == 3) ? 1 : 0;
                else {
                    if(count < 2 || count > 3) nextState[i][j] = 0;
                    else nextState[i][j] = 1;
                }
            }
        }

         for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++) {
               board[i][j] = nextState[i][j];
            }
        }

    }

    private int countLive(int[][]board , int i , int j) {
        int ans = 0;
        if(j > 0){
            ans += (i > 0) ? (board[i - 1][j - 1]) : 0;
            ans += (board[i][j - 1]);
            ans += (i < board.length - 1) ? (board[i + 1][j - 1]) : 0;
        }
        if(j < board[0].length - 1){
             ans += (i > 0) ? (board[i - 1][j + 1]) : 0;
            ans += (board[i][j + 1]);
            ans += (i < board.length - 1) ? (board[i + 1][j + 1]) : 0;
        }
        if(i > 0) ans += board[i - 1][j];
        if(i < board.length - 1) ans += board[i + 1][j];
        return ans;
    }
}