class Solution {

    static class coords{
        int i;
        int j;
        coords(int i,int j){
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i < r; i ++){
            boolean[] curRow = new boolean[c];
            for(int j = 0; j < c; j ++){
                curRow[j] = false;
            }
            visited[i] = curRow;
        }

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid,i,j,visited);
                    count ++;
                } 
            }
        }
        return count;
    }

    private static void bfs(char[][] grid , int i, int j,boolean[][] visited){
        Queue<coords> q = new LinkedList<>();
        q.offer(new coords(i,j));
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {
            coords curCoords = q.poll();
            for(int[] direction : directions){
                int curRow = curCoords.i + direction[0];
                int curCol = curCoords.j + direction[1];
                if(curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid[0].length) continue;
                if(grid[curRow][curCol] == '1' && !visited[curRow][curCol]){
                    q.offer(new coords(curRow,curCol));
                    visited[curRow][curCol] = true;
                }
            }
        }
    }

}