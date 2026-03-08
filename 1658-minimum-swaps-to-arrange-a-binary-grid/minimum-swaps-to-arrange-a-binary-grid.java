class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZerosCount = new int[n];
        int steps = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0)
                    count++;
                else
                    break;
            }
            trailingZerosCount[i] = count;
        }

        for(int i = 0; i < n; i ++){
            int neededZeros = n - i - 1;
            int j = i;
            while(j < n){
                if(neededZeros <= trailingZerosCount[j]) break;
                j ++;
            }
            if(j == n) return -1;
            steps += j - i;
            while( j > i){
                int temp = trailingZerosCount[j];
                trailingZerosCount[j] = trailingZerosCount[j - 1];
                trailingZerosCount[j - 1] = temp;
                j --;
            }
        }
        return steps;
    }
}