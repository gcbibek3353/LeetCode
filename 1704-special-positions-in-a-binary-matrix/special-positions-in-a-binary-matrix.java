class Solution {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[] rowCount = new int[r];
        int[] colCount = new int[c];
        int specialPositionCount = 0;

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++) {
                if(mat[i][j] == 1){
                    rowCount[i] ++;
                    colCount[j] ++;
                }
            }
        }

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++) {
                if(rowCount[i] == 1 && colCount[j] == 1 && mat[i][j] == 1){
                    specialPositionCount ++;
                }
            }
        }
        return specialPositionCount;
    }
}