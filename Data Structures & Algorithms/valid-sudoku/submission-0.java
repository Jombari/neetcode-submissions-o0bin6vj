class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] squares = new int[9][10];
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];

        for(int i = 0 ; i<9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                int row = i/3;
                int col = j /3;
                int square = row*3 + col;
                if(++rows[i][board[i][j] - '0'] >1 || ++cols[j][board[i][j] - '0'] > 1 || ++squares[square][board[i][j] - '0'] > 1)
                    return false;
            }
        }
        return true;
    }
}
