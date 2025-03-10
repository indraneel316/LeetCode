class Solution {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int isRowZero = 1;
        int isColZero =1;

        for(int i=0; i< row; i++) {
            if(matrix[i][0]==0) { // first col
              isColZero =0;
            }
        }

        for(int j=0; j< col; j++) {
            if(matrix[0][j]==0) { // first row
              isRowZero =0;
            }
        }

        for(int i =1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] =0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i =1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j] =0;

                }
            }}

            if(isRowZero==0) {
                for(int j =0;j<col;j++) {
                    matrix[0][j]=0;
                }
            }
            if(isColZero==0) {
                for(int i =0;i<row;i++) {
                    matrix[i][0]=0;
                }
            }



        
    }
}