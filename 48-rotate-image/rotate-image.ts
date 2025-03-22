/**
 Do not return anything, modify matrix in-place instead.
 */
function rotate(matrix: number[][]): void {
//   Two ways : (transpose and horizontal rotate) or (vertical rotate and transpose)
// transpose and horizontal rotate (horizontal rotate takes O(n*log(n))
// vertical rotate and transpose (vertical rotate takes O(log(n))) only

// vertical rotate
let l = 0; 
let r = matrix.length - 1;
while(l < r) [matrix[l ++], matrix[r --]] = [matrix[r],matrix[l]];
for(let i = 0; i < matrix.length; i ++){
    for(let j = i + 1; j < matrix.length; j ++){
        [matrix[i][j],matrix[j][i]] = [matrix[j][i],matrix[i][j]];
    }
}
};