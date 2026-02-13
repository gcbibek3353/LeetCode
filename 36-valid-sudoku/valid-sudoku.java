class Solution {
    public boolean isValidSudoku(char[][] board) {
          Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] blocks = new HashSet[9];
    for(int i = 0; i < 9; i ++){
        rows[i] = new HashSet<Character>();
        cols[i] = new HashSet<Character>();
        blocks[i] = new HashSet<Character>();
    }

    for(int i = 0; i < board.length; i ++){
        for(int j = 0; j < board.length; j ++) {
            int blockIndex = (i / 3) * 3 + j / 3;
            Character curString = board[i][j];
            if(curString == '.') continue;
            if(rows[i].contains(curString) || cols[j].contains(curString) || blocks[blockIndex].contains(curString)) return false;
            else{
                rows[i].add(curString);
                cols[j].add(curString);
                blocks[blockIndex].add(curString);
            } 

        }
    }
    return true;
    }
}