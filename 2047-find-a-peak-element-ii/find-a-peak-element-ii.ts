function findPeakGrid(mat: number[][]): number[] {
    let startCol = 0;
    let endCol = mat[0].length - 1;

    while (startCol <= endCol) {
        let maxRow = 0;
        const midCol = Math.floor((startCol + endCol) / 2);

        // Find the max element in the mid column
        for (let row = 0; row < mat.length; row++) {
            if (mat[row][midCol] >= mat[maxRow][midCol]) {
                maxRow = row;
            }
        }

        const leftIsBig = (midCol - 1 >= startCol) && (mat[maxRow][midCol - 1] > mat[maxRow][midCol]);
        const rightIsBig = (midCol + 1 <= endCol) && (mat[maxRow][midCol + 1] > mat[maxRow][midCol]);

        if (!leftIsBig && !rightIsBig) {
            return [maxRow, midCol];  // Found the peak
        } else if (rightIsBig) {
            startCol = midCol + 1;    // Move to the right half
        } else {
            endCol = midCol - 1;      // Move to the left half
        }
    }

    return [];
}
