class Solution {

    int maxIslandSize = 0;
    class Coords{
        int row;
        int col;
        public Coords(int r , int c ) {
            row = r;
            col = c;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];


        for(int i = 0; i < r; i ++) {
            for(int j = 0; j < c; j ++) {
                if(grid[i][j] == 0 || visited[i][j]) continue;
                bfs(i , j , visited, grid);
            }
        }
        return maxIslandSize;
    }

    private void bfs(int i , int j , boolean[][] visited, int[][] grid) {
        if(visited[i][j]) return;
        Queue<Coords> q = new LinkedList<>();
        q.offer(new Coords(i , j));
        visited[i][j] = true;
        int curIslandSize = 1;

        int[][] directions = {{-1 , 0} , {1 , 0} , {0 , 1} , { 0 , -1}};
        
        while(!q.isEmpty()){
            int queueSize = q.size();
            for(int k = 0; k < queueSize; k ++) {
                Coords curCoord = q.poll();
                for(int[] dir : directions) {
                    int curRow = curCoord.row + dir[0];
                    int curCol = curCoord.col + dir[1];
                    if(curRow < 0 || curRow >= grid.length) continue;
                    if(curCol < 0 || curCol >= grid[0].length) continue;
                    if(grid[curRow][curCol] == 0 || visited[curRow][curCol]) continue;
                    // 0 or visited check
                    curIslandSize ++;
                    q.offer(new Coords(curRow , curCol));
                    visited[curRow][curCol] = true;
                }
            }
        }
        // System.out.printf("i : %d , j : %d , curSize : %d \n", i , j , curIslandSize);
        maxIslandSize = Math.max(maxIslandSize, curIslandSize);
    }
}