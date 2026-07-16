class Solution {
    class Coords{
        int r;
        int c;
        public Coords(int row , int col){
            r = row;
            c = col;
        }
    }

    boolean[][] isNotSurrounded; 
    boolean[][] visited; 
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        isNotSurrounded = new boolean[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i < c; i ++){
            if(board[0][i] == 'O') bfs(0 , i , board);
        }
        for(int i = 0; i < r; i ++){
            if(board[i][c - 1] == 'O') bfs(i , c - 1 , board);
        }
        for(int i = c - 1; i >= 0; i --){
            // System.out.printf("%d , %d , %c \n", r - 1 , i , board[r - 1][i]);
            if(board[r - 1][i] == 'O') bfs(r - 1 , i , board);
        }
        for(int i = r - 1; i >= 0; i --){
            if(board[i][0] == 'O') bfs(i , 0 , board);
        }

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++) {
                // System.out.printf("%d , %d , %b \n",i,j,isNotSurrounded[i][j]);
                if(board[i][j] == 'O' && !isNotSurrounded[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void bfs(int i , int j, char[][] board){
        if(visited[i][j]) return;
        isNotSurrounded[i][j] = true;
        visited[i][j] = true;
        int r = board.length;
        int c = board[0].length;
        // Queue<Coords> q = new LinkedList<>();
        int[][] directions = {{0 , 1} , {0 , -1}, {1 , 0}, { -1 , 0}};
        for(int[] direction : directions) {
            int curRow = i + direction[0];
            int curCol = j + direction[1];
            if(curRow < 0 || curRow >= r) continue;
            if(curCol < 0 || curCol >= c) continue;
            if(board[curRow][curCol] == 'X') continue;
            bfs(curRow , curCol , board);
        }
    }

}