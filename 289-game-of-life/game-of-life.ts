/**
 Do not return anything, modify board in-place instead.
 */
function gameOfLife(board: number[][]): void {
    // const temp = Array.from({ length: board.length }, () => new Array(board[0].length).fill(0));

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            let curCount = 0;
            if (i !== 0 && board[i - 1][j] % 2 === 1) curCount += 1;
            if (i !== board.length - 1 && board[i + 1][j] % 2 === 1) curCount += 1;
            if (j !== 0 && board[i][j - 1] % 2 === 1) curCount += 1;
            if (j !== board[0].length - 1 && board[i][j + 1] % 2 === 1) curCount += 1;
            if (i !== 0 && j !== 0 && board[i - 1][j - 1] % 2 === 1) curCount += 1;
            if (i !== 0 && j !== board[0].length - 1 && board[i - 1][j + 1] % 2 === 1) curCount += 1;
            if (i !== board.length - 1 && j !== 0 && board[i + 1][j - 1] % 2 === 1) curCount += 1;
            if (i !== board.length - 1 && j !== board[0].length - 1 && board[i + 1][j + 1] % 2 === 1) curCount += 1;

            if (board[i][j] === 0) board[i][j] = (curCount === 3) ? 2 : 0;
            else board[i][j] = (curCount === 2 || curCount === 3) ? 3 : 1;
        }
    }

    // for (let i = 0; i < board.length; i++) {
    //     for (let j = 0; j < board[0].length; j++) {
    //         console.log(board[i][j]);
    //     }
    //     console.log("\n");
    // }


    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (board[i][j] === 0 || board[i][j] === 1) board[i][j] = 0;
            else board[i][j] = 1;
        }
    }


};