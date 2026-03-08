class Solution {

    static class coords {
        int i;
        int j;

        coords(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int r = image.length;
        int c = image[0].length;
        Queue<coords> q = new LinkedList<>();
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        q.offer(new coords(sr, sc));
        int colorToChange = image[sr][sc];
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            coords curCoords = q.poll();
            for (int i = 0; i < directions.length; i++) {
                int curRow = curCoords.i + directions[i][0];
                int curCol = curCoords.j + directions[i][1];
                if (curRow < 0 || curRow >= r || curCol < 0 || curCol >= c || image[curRow][curCol] != colorToChange)
                    continue;
                image[curRow][curCol] = color;
                q.offer(new coords(curRow, curCol));
            }
        }
        return image;
    }
}