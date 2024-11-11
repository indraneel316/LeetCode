class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;

        for(int i=0; i<n-1;i++) {
            for(int j = i+1; j<n;j++) { //j=i+1 because we don't want to reswap already swapped elements


                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }

        for (int i =0; i<n;i++) {
            int arr[] = matrix[i];
            int p1 =0;
            int p2 =n-1;
            while(p1<p2) {
            int temp = arr[p1];
               arr[p1]= arr[p2];
               arr[p2]= temp;
               p1++;
               p2--;
            }
        }
    }
}