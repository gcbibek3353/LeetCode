function diagonalSum(mat: number[][]): number {
    const r = mat.length;
    let sum = 0;
    for(let i = 0; i < r; i ++){
       sum += mat[i][i];
       if(i != r - 1 - i) sum += mat[i][r-1-i];
    }
    return sum;
};