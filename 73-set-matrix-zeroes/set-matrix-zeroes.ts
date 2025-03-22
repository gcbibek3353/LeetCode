/**
 Do not return anything, modify matrix in-place instead.
 */
function setZeroes(matrix: number[][]): void {
    let firstRowContainsZero = false;
    let firstColContainsZero = false;
    // Checking if first row contains zero
    for(let i = 0; i < matrix[0].length; i ++){
        if(matrix[0][i] === 0) firstRowContainsZero = true;
    }
    // checking if first col contains zero
    for(let i = 0; i < matrix.length; i ++){
        if(matrix[i][0] === 0) firstColContainsZero = true;
    }
    // making first row and first col zero whose row or cols contains zero
    for(let r = 1; r < matrix.length ; r ++){
        for(let c = 1; c < matrix[0].length; c ++){
            if(matrix[r][c] === 0){
                matrix[r][0] = 0;
                matrix[0][c] = 0;
            }
        }
    }

    console.log(matrix);
    // setting rows with zeros 
    for(let i = 1 ; i < matrix.length; i ++) {
        if(matrix[i][0] === 0){
            for(let j = 0; j < matrix[0].length; j ++){
                matrix[i][j] = 0;
            }
        }
    }
    //setting cols with zeros
    for(let i = 1; i < matrix[0].length; i ++){
        if(matrix[0][i] === 0){
            for(let j = 0; j < matrix.length; j ++){
                matrix[j][i] = 0;
            }
        }
    }
    // if first row contains zero make all it's elements zero
    if(firstRowContainsZero){
        for(let i = 0; i < matrix[0].length; i ++) matrix[0][i] = 0;
    }
    // if first col contains zero make all it's elements zero
    if(firstColContainsZero){
        for(let i = 0; i < matrix.length; i ++) matrix[i][0] = 0;
    }
};