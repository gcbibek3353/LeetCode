class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int curRow = mid / col;
            int curCol = mid % col;
            int curVal = matrix[curRow][curCol];
            if( curVal == target) return true;
            else if (curVal < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}