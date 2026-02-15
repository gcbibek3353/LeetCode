class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = 0;
        int r = matrix.length - 1;
        // swapping rows
        while(l < r) {
            int[] temp = matrix[l];
            matrix[l] = matrix[r];
            matrix[r] = temp;
            l ++;
            r --;
        }

        // Transpose 
        int[][] transpose = new int[n][n];
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                transpose[i][j] = matrix[j][i];
            }
        }

         for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                matrix[i][j] = transpose[i][j];
            }
        }
    }
}