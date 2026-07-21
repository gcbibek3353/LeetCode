class Solution {
   public int equalPairs(int[][] grid) {
    Map<List<Integer>, Integer> colMap = new HashMap<>();
    int n = grid.length;

    // Store columns
    for (int j = 0; j < n; j++) {
        List<Integer> column = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            column.add(grid[i][j]);
        }

        colMap.put(column, colMap.getOrDefault(column, 0) + 1);
    }

    int ans = 0;

    // Check rows
    for (int i = 0; i < n; i++) {
        List<Integer> row = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            row.add(grid[i][j]);
        }

        ans += colMap.getOrDefault(row, 0);
    }

    return ans;
}
}