class Solution {
    static class coords {
        int i;
        int j;

        coords(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solve(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] isSurrounded = new boolean[r][c];
        boolean[][] visited = new boolean[r][c];

          for(int i = 0; i < r; i ++){
            boolean[] curRow = new boolean[c];
            boolean[] surroundedCurRow = new boolean[c]; 
            for(int j = 0; j < c; j ++){
                curRow[j] = false;
                surroundedCurRow[j] = false;
            }
            visited[i] = curRow;
            isSurrounded[i] = surroundedCurRow;
        }

        for (int i = 0; i < c; i++) {
            char curChar = grid[0][i];
            if (curChar == 'O' && !visited[0][i])
                bfs(grid, isSurrounded, visited, 0, i);
        }
        for (int i = 1; i < r; i++) {
            char curChar = grid[i][c - 1];
            if (curChar == 'O' && !visited[i][c - 1])
                bfs(grid, isSurrounded, visited, i, c - 1);
        }
        for (int i = c - 2; i >= 0; i--) {
            char curChar = grid[r - 1][i];
            if (curChar == 'O' && !visited[r - 1][i])
                bfs(grid, isSurrounded, visited, r - 1, i);
        }
        for (int i = r - 2; i >= 1; i--) {
            char curChar = grid[i][0];
            if (curChar == 'O' && !visited[i][0])
                bfs(grid, isSurrounded, visited, i, 0);
        }

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(isSurrounded[i][j]){
                    grid[i][j] = 'O';
                } 
                else{
                    grid[i][j] = 'X';     
                }
            }
        }
    }

    private void bfs(char[][] grid, boolean[][] isSurrounded, boolean[][] visited, int i, int j) {
        Queue<coords> q = new LinkedList<>();
        q.offer(new coords(i, j));
        visited[i][j] = true;
        isSurrounded[i][j] = true;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

         while(!q.isEmpty()) {
            coords curCoords = q.poll();
            for(int[] direction : directions){
                int curRow = curCoords.i + direction[0];
                int curCol = curCoords.j + direction[1];
                if(curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid[0].length) continue;
                if(grid[curRow][curCol] == 'O' && !visited[curRow][curCol]){
                    q.offer(new coords(curRow,curCol));
                    visited[curRow][curCol] = true;
                    isSurrounded[curRow][curCol] = true;
                }
            }
        }
    }
}