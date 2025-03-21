/**
 Do not return anything, modify matrix in-place instead.
 */
function setZeroes(matrix: number[][]): void {
    let rowsToMadeZeros = [];
    let colsToMadeZeros = [];
    for(let i = 0; i < matrix.length; i ++){
        for(let j = 0; j < matrix[0].length; j ++){
            if(matrix[i][j] === 0){
                rowsToMadeZeros.push(i);
                colsToMadeZeros.push(j);
            }
        }
    }
    for(let i = 0; i < rowsToMadeZeros.length; i ++){
        for(let j = 0; j < matrix[0].length; j ++){
            matrix[rowsToMadeZeros[i]][j] = 0;
        }
    }
    for(let i = 0; i < matrix.length; i ++){
        for(let j = 0; j < colsToMadeZeros.length; j ++){
            matrix[i][colsToMadeZeros[j]] = 0;
        }
    }
};