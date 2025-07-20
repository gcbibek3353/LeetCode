function searchMatrix(matrix: number[][], target: number): boolean {
    let r = matrix.length;
    let c = matrix[0].length;
    let curRow = 0;
    let curCol = c - 1;

    while (curRow < r && curCol >= 0) {
        const val = matrix[curRow][curCol];
        if (val === target) return true;
        else if (val < target) curRow++;
        else curCol--;
    }
    return false;
};