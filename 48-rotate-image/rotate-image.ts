/**
 Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix: number[][]): void {
    let l = 0;
    let r = matrix.length - 1;
    let n = matrix.length;
    while (l < r) {
        let temp = matrix[l];
        matrix[l] = matrix[r];
        matrix[r] = temp;
        l++;
        r--;
    }
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
        }
    }

};