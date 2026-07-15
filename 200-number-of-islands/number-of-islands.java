class Solution {

    class Cell {
        int row;
        int col;

        public Cell(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int noOfIslands = 0;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '0' || visited[i][j])
                    continue;
                noOfIslands++;
                Queue<Cell> q = new LinkedList<>();
                q.offer(new Cell(i, j));
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    Cell cur = q.poll();

                    for (int[] dir : directions) {
                        int nr = cur.row + dir[0];
                        int nc = cur.col + dir[1];

                        if (nr < 0 || nr >= r || nc < 0 || nc >= c)
                            continue;

                        if (grid[nr][nc] == '0' || visited[nr][nc])
                            continue;

                        visited[nr][nc] = true;
                        q.offer(new Cell(nr, nc));
                    }
                }
            }
        }
        return noOfIslands;
    }
}