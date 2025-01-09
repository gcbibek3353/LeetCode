function transpose(matrix: number[][]): number[][] {
    const output : number[][] = [];
    const r : number = matrix.length;
    const c : number = matrix[0].length;

    for(let i = 0; i < r; i ++){
        for(let j = 0; j < c; j ++){
            if(!output[j]) output[j] = [];
            output[j][i] = matrix[i][j];
        }
    }
    return output;

};