class Solution {
    static class coords{
        int i;
        int j;
        coords(int i,int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];
        int freshOranges = 0;
        int time = 0;
        Queue<coords> q = new LinkedList<>();
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c ;j ++){
                if(grid[i][j] == 1) freshOranges ++;
                else if (grid[i][j] == 2) q.offer(new coords(i,j));
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty() && freshOranges > 0 ){
            int size = q.size();
            while(size -- > 0) {
                coords curCoords = q.poll();
                for(int i = 0; i < directions.length; i ++){
                    int curRow = curCoords.i + directions[i][0];
                    int curCol = curCoords.j + directions[i][1];
                    if(curRow < 0 || curRow >= r
                    || curCol < 0 || curCol >= c 
                    || grid[curRow][curCol] != 1) continue;
                    q.offer(new coords(curRow,curCol));
                    grid[curRow][curCol] = 2;
                    freshOranges --;
                }
            }
            time ++;
        }
 return freshOranges > 0 ? -1 : time;
    }
}