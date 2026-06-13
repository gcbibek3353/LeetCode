class Solution {
    public int equalPairs(int[][] grid) {
         int n = grid.length;
        int count = 0;

        // Store each row and its frequency
        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {

            List<Integer> row = new ArrayList<>();

            for (int c = 0; c < n; c++) {
                row.add(grid[r][c]);
            }

            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        // Build each column and check if it exists as a row
        for (int c = 0; c < n; c++) {

            List<Integer> col = new ArrayList<>();

            for (int r = 0; r < n; r++) {
                col.add(grid[r][c]);
            }

            count += map.getOrDefault(col, 0);
        }

        return count;
    }
}