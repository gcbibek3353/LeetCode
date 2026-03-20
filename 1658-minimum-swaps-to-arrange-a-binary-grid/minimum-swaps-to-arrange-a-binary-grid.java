class Solution {
    public int minSwaps(int[][] grid) {
        int row = grid.length;
        int[] trailingZerosCount = new int[row];
        int steps = 0;

        for(int i = 0; i < grid.length; i ++){
            int count = 0;
            for(int j = row - 1; j >= 0; j --){
                if(grid[i][j] == 0) count ++;
                else break;
            }
            trailingZerosCount[i] = count;
        }
        
        for(int r = 0; r < grid.length; r ++){
            int requiredZeros = row - r - 1;

            int j = r;
            while(j < row && requiredZeros > trailingZerosCount[j]){
                j ++;
            }
            if(j == row) return -1;
            steps += j - r;

            while(j > r){
                int temp = trailingZerosCount[j];
                trailingZerosCount[j] = trailingZerosCount[j - 1];
                trailingZerosCount[j - 1] = temp;
                j --;
            }
        }
        return steps;
    }
}