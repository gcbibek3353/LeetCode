/**
 Do not return anything, modify matrix in-place instead.
 */
function setZeroes(matrix: number[][]): void {
    let r = matrix.length;
    let c = matrix[0].length;
    let rows = new Array(r);
    let cols = new Array(c);
    for (let i = 0; i < r; i++) {
        for (let j = 0; j < c; j++) {
            if (matrix[i][j] === 0) {
                rows[i] = 0;
                cols[j] = 0;
            }
        }
    }

    for (let i = 0; i < rows.length; i++) {
        if (rows[i] === 0) {
            for (let j = 0; j < c; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    for (let i = 0; i < cols.length; i++) {
        if (cols[i] === 0) {
            for (let j = 0; j < r; j++) {
                matrix[j][i] = 0;
            }
        }
    }

};