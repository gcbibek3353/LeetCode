class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = grid.length;
        int c = grid[0].length;
        int[][] dup = new int[r][c];
        if(k == 0) dup = grid;

        for (int count = 0; count < k; count++) {
            dup[0][0] = grid[r - 1][c - 1];
            for (int i = 1; i < r; i++) {
                dup[i][0] = grid[i - 1][c - 1];
            }
            for (int i = 0; i < r; i++) {
                for (int j = 1; j < c; j++) {
                    dup[i][j] = grid[i][j - 1];
                }
            }
            grid = new int[r][c];
            for(int i = 0; i < r; i ++){
                for(int j = 0; j < c; j ++) {
                    grid[i][j] = dup[i][j];
                }
            }
        }

        for (int i = 0; i < r; i++) {
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                curList.add(dup[i][j]);
            }
            ans.add(curList);
        }
        return ans;
    }
}