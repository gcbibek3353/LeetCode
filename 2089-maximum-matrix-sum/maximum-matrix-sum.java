class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negative_count = 0;
        int min_abs_value = Integer.MAX_VALUE;
        for(int[] row : matrix){
            for(int value : row) {
                int abs_value = Math.abs(value);
                sum += abs_value;
                min_abs_value = Math.min(min_abs_value,abs_value);
                if(value < 0) negative_count ++;
            }
        }
        if(negative_count % 2 == 1) return sum - (2 * min_abs_value);
        return sum;
    }
}