class Solution {
    public class Coord{
        int r;
        int c;
        public Coord(int r , int c) {
            this.r = r;
            this.c = c;
        }
    }
    int[][] directions = {{-1 , 0}, {1 , 0}, {0, -1}, { 0 , 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    int curArea = bfs(i , j , grid, visited);
                    maxArea = Math.max(curArea , maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int i , int j , int[][] grid , boolean[][] visited) {
        Queue<Coord> q = new LinkedList<>();
        Coord firstCoord = new Coord(i , j);
        q.offer(firstCoord);
        int area = 1;
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int count = 0; count < size; count ++) {
                Coord curCoord = q.poll();
                for(int[] dir : directions) {
                    int curRow = curCoord.r + dir[0];
                    int curCol = curCoord.c + dir[1];
                    if(
                        curRow >= 0 && curRow < grid.length &&
                        curCol >= 0 && curCol < grid[0].length &&
                        grid[curRow][curCol] == 1 && 
                        !visited[curRow][curCol]
                    ){
                        Coord newCoord = new Coord(curRow , curCol); 
                        q.offer(newCoord);
                        visited[curRow][curCol] = true;
                        area ++;
                        // System.out.printf("curRow : %d , curCol : %d , area : %d , i : %d , j : %d \n", curRow , curCol , area , i , j);
                    } 
                }
            }
        }
        return area;
    }
}