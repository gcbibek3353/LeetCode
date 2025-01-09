function diagonalSum(mat: number[][]): number {
    const r = mat.length;
    let sum = 0;
    for(let i = 0; i < r; i ++){
        for(let j = 0; j < r; j ++){
            if(i === j || i+j === r - 1) sum += mat[i][j];
        }
    }
    return sum;
};