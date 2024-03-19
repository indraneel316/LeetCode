class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        for(int i =0; i<9; i++) {
             rowSet = new HashSet<>();
             colSet = new HashSet<>();
            for(int j =0; j<9;j++) {
               if(board[i][j]!=('.')) {
                if(!rowSet.contains(board[i][j])) {
                    rowSet.add(board[i][j]);
                }
                else {
                    return false;
                }}
                if(board[j][i]!=('.')) {
               if(!colSet.contains(board[j][i])) {
                    colSet.add(board[j][i]);
                }
                else {
                    return false;
                }
                }
            }
        }
        HashSet<Character> blockSet = new HashSet<>();
        for(int i =0; i<9; i=i+3) {
             for(int j =0; j<9; j=j+3) {
                 // HashSet<Character> blockSet = new HashSet<>();
                 int rowIndex = i;
                 int colIndex = j;
                 int rows = rowIndex+3;
                 int cols = colIndex+3;
                 for(int k =rowIndex; k<rows; k++) {
                     for(int l=colIndex;l<cols;l++) {
                         if(board[k][l] != '.') {
                             if(!blockSet.contains(board[k][l])) {
                                 blockSet.add(board[k][l]);
                             }
                             else {
                                 return false;
                             }
                         }
                     }
                 }
              blockSet.clear();
             }
            
        }
        return true;
    }
}