class Solution {
    int[][] directions = {{0 , 1} , {0 , -1}, { 1 , 0}, {-1 , 0}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == word.charAt(0) && wordSearch(board , visited , i, j , word , 0)) return true;
            }
        }
        return false;
    }

    private boolean wordSearch(char[][] board , boolean[][] visited , int row , int col , String word , int curCharIndexInWord) {
        if(curCharIndexInWord == word.length()) return true;
        if( row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(curCharIndexInWord) ||  visited[row][col]) return false;
        visited[row][col] = true;
        for(int[] direction : directions){
            if(wordSearch(board , visited , row + direction[0] , col + direction[1] , word , curCharIndexInWord + 1)) return true;
        }
        visited[row][col] = false;
        return false;
    }
}