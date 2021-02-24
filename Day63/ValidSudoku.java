class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
       for (int i = 0; i < board.length; ++i){
           for (int j = 0; j < board.length; ++j){
               if (board[i][j] == '.')continue;
               char c = board[i][j];
                board[i][j] = '.';
               if (!canPlace(board, i, j, c)){
                   return false;
               }else{
                   board[i][j] = c;
               }
           }
       }
        return true;
    }
    
    public static boolean canPlace(char[][] board,int row, int col, char charToPlace){
        for (int i = 0; i < board.length; ++i){
            if (board[row][i] == charToPlace)return false;
            if (board[i][col] == charToPlace)return false;
        }
        
        int gridSize = (int)Math.sqrt(board.length);
        int vertInd = row/gridSize;
        int horInd = col/gridSize;
        int topLeftRow = gridSize * vertInd;
        int topRightCol = gridSize * horInd;
        for (int i = 0; i < gridSize; ++i){
            for (int j = 0; j < gridSize; ++j){
                if (board[topLeftRow + i][topRightCol + j] == charToPlace)return false;
            }
        }
        return true;
    }
}