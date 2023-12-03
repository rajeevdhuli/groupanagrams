class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rotate = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                rotate[j][m-i-1] = matrix[i][j];
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                matrix[i][j] = rotate[i][j];
            }
        }
    }
}

Transpose and reverse each row - 

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m ; i++){
            for(int j = i ; j < m ; j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0 ; i < m ; i++){
            int j = 0;
            int k = m - 1;
            while(j< n && j < k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                k--;
                j++;
            }
        }
    }
}
