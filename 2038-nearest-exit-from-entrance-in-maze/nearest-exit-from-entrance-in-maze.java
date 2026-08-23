class Solution {

    public class Coord {
        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<Coord> q = new LinkedList<>();

        q.offer(new Coord(entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Coord current = q.poll();

                for (int[] dir : directions) {
                    int newRow = current.r + dir[0];
                    int newCol = current.c + dir[1];

                    if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols ||
                        visited[newRow][newCol] ||
                        maze[newRow][newCol] == '+') {
                        continue;
                    }

                    // Check if this is an exit
                    if (newRow == 0 || newRow == rows - 1 ||
                        newCol == 0 || newCol == cols - 1) {
                        return moves + 1;
                    }

                    visited[newRow][newCol] = true;
                    q.offer(new Coord(newRow, newCol));
                }
            }

            moves++;
        }

        return -1;
    }
}