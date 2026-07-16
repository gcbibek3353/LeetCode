class Solution {
    class Coord{
        int r;
        int c;
        public Coord(int row , int col){
            r = row;
            c = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        Queue<Coord> q = new LinkedList<>();
        int orangeCount = 0;
        int rottenCount = 0;

        for(int i = 0; i< r; i ++){
            for(int j = 0; j < c; j ++) {
                if(grid[i][j] != 0) orangeCount ++;
                if(grid[i][j] == 2){
                    rottenCount ++;
                    q.offer(new Coord(i , j));
                    // visited[i][j] = true;
                }
            }
        }

        int timeSpent = 0;
        int[][] directions = {{0 , 1} , {0 , -1}, {1 , 0}, { -1 , 0}};
        while(!q.isEmpty()){
            int queueSize = q.size();
            timeSpent ++;
            for(int i = 0; i < queueSize; i ++) {
                Coord curCord = q.poll();
                for(int[] direction : directions) {
                    int curRow = curCord.r + direction[0];
                    int curCol = curCord.c + direction[1];
                    if(curRow < 0 || curRow >= r) continue;
                    if(curCol < 0 || curCol >= c) continue;
                    if(visited[curRow][curCol] || grid[curRow][curCol] != 1) continue;
                    q.offer(new Coord(curRow , curCol));
                    rottenCount ++;
                    visited[curRow][curCol] = true;
                }
            }
        }

        return rottenCount == orangeCount ? ((timeSpent == 0) ? 0 : timeSpent - 1) : -1;

    }
}