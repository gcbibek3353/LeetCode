/**
 Do not return anything, modify board in-place instead.
 */
function gameOfLife(board: number[][]): void {
    // const x = new Array<number>(board[0].length).fill(0);
    // const temp = new Array<number[]>(board.length).fill(x);
const temp = Array.from({ length: board.length }, () => new Array(board[0].length).fill(0));

//    for (let i = 0; i < board.length; i++) {
//         for (let j = 0; j < board[0].length; j++) {
//             console.log(temp[i][j]);
//         }
//         console.log("\n")
//    }

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (board[i][j] === 0) continue;
            if (i !== 0) temp[i - 1][j] += 1;
            if (i !== board.length - 1) temp[i + 1][j] += 1;
            if (j !== 0) temp[i][j - 1] += 1;
            if (j !== board[0].length - 1) temp[i][j + 1] += 1;
            if (i !== 0 && j !== 0) temp[i - 1][j - 1] += 1;
            if (i !== 0 && j !== board[0].length - 1) temp[i - 1][j + 1] += 1;
            if (i !== board.length - 1 && j !== 0) temp[i + 1][j - 1] += 1;
            if (i !== board.length - 1 && j !== board[0].length - 1) temp[i + 1][j + 1] += 1;
        }
    }

   for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            console.log(temp[i][j]);
        }
        console.log("\n")
   }


    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if(board[i][j] === 0){
                board[i][j] = (temp[i][j] === 3) ? 1 : 0;
            }
            else{
                board[i][j] = (temp[i][j] === 2 || temp[i][j] === 3) ? 1 : 0;    
            }
        }
    }

};