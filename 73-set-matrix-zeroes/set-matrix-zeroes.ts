/**
 Do not return anything, modify matrix in-place instead.
 */
function setZeroes(matrix: number[][]): void {
    let r = matrix.length;
    let c = matrix[0].length;
    let first_row_contains_zero = false;
    let first_col_contains_zero = false;

    for (let i = 0; i < r; i++) {
        if (matrix[i][0] === 0) first_col_contains_zero = true;
    }

    for (let i = 0; i < c; i++) {
        if (matrix[0][i] === 0) first_row_contains_zero = true;
    }

    for (let i = 1; i < r; i++) {
        for (let j = 1; j < c; j++) {
            if (matrix[i][j] === 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for (let i = 1; i < r; i++) {
        if (matrix[i][0] === 0) {
            for (let j = 0; j < c; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    for (let i = 1; i < c; i++) {
        if (matrix[0][i] === 0) {
            for (let j = 0; j < r; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    if (first_row_contains_zero) {
        for (let i = 0; i < c; i++) matrix[0][i] = 0;
    }

    if (first_col_contains_zero) {
        for (let i = 0; i < r; i++) matrix[i][0] = 0;
    }


};