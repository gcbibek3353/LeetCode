class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int swaps = 0;
        int[] trailingZeros = new int[n];

        for(int i = 0; i < n; i ++){
            int count = 0;
            int j = n - 1;
            while(j >= 0){
                if(grid[i][j] == 0) count ++;
                else break;
                j --;
            }
            trailingZeros[i] = count;
        }
        for(int i = 0; i < n; i ++){
            int needed = n - i - 1;
            int j = i;
            while(j < n && needed > trailingZeros[j]){
                j ++;
            }
            if(j == n) return -1;
            swaps += j - i;
            while(j > i){
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                j --;
            }
        }
        return swaps;

    }
}