class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = m - 1;
        List<Integer> ans = new ArrayList<>();

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            if (rowStart != rowEnd) {
                for (int i = colEnd - 1; i >= colStart; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
            }
            if (colStart != colEnd) {
                for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
                    ans.add(matrix[i][colStart]);
                }
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }

        return ans;
    }
}