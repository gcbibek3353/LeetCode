class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zerosCount = new int[n];
        int steps = 0;

        for(int i = 0; i < n; i ++){
            int curCount = 0;
            int j = n - 1;
            while(j > 0){
                if(grid[i][j --] == 0) curCount ++;
                else break;
            }
            zerosCount[i] = curCount;
        }

        for(int i = 0; i < n; i ++){
            int needed = n - i - 1;
            int j = i;
            while(j < n) {
                if(zerosCount[j] >= needed) break;
                j ++;
            }
            if(j == n) return -1;
            steps += j - i;

            while(j > i) {
                int temp = zerosCount[j];
                zerosCount[j] = zerosCount[j - 1];
                zerosCount[j - 1] = temp;
                j --;
            }
        }
        return steps;
    }
}