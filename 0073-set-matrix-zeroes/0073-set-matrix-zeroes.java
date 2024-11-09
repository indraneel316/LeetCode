class Solution {
    public void setZeroes(int[][] matrix) {
        int row =matrix.length;
        int col = matrix[0].length;
         Integer rowIter = 0;
         int isRowZero = 1;
         int isColumnZero =1;

        //  int [] topArray = new int[col];
        //  int [] sideArray = new int[row];
        for(int j =0; j< col;j++) {
            if(matrix[0][j]==0) { //first row 
                isRowZero = 0;
            }
        }
        for(int i =0; i<row; i++){
            if(matrix[i][0]==0) { //first column
            isColumnZero =0;
            }
        }
        
            for(int i =1; i< row; i++) {
                for(int j =1; j<col; j++ ) {
                    if(matrix[i][j]==0) {
                       matrix[0][j]=0 ;
                       matrix[i][0]=0;
                    }
                }
            }
            for(int j=1; j< col;j++) {
                if(matrix[0][j]==0) {
                    for(int i=0; i<row;i++){
                        matrix[i][j]=0;
                    }
                }
            }
            for(int i =1; i<row; i++) {
                if(matrix[i][0]==0) {
                    for(int j=0; j<col; j++) {
                        matrix[i][j]=0;
                    }
                }
            }
            if(isRowZero ==0) {
                for(int j=0; j<col; j++) {
                    matrix[0][j]=0;
                }
            }
            if(isColumnZero==0) {
                for(int i =0;i<row;i++) {
                    matrix[i][0] =0;
                }
            }
        }
    }
