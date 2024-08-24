O(2*(N*M)) , O(N) + O(M) - 

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        for(int i= 0 ;i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(row[i] == -1 || col[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

 O(2*(N*M)),O(1) -
class Solution {
    public void setZeroes(int[][] matrix) {
        // Get the dimensions of the matrix
        int n = matrix.length;
        int m = matrix[0].length;

        // Variables to track if the first row or first column needs to be set to zero
        int col0 = -1;  // -1 means no zeros in the first column initially
        int row0 = -1;  // -1 means no zeros in the first row initially

        // First pass: Mark zeros in the first row and column for the corresponding rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If a zero is found
                if (matrix[i][j] == 0) {
                    // Check if the zero is in the first column
                    if (j == 0) {
                        col0 = 0;
                    }
                    // Check if the zero is in the first row
                    if (i == 0) {
                        row0 = 0;
                    }
                    // Mark the corresponding first row and first column positions if not in the first row or column
                    if (j != 0) {
                        matrix[0][j] = 0;
                    }
                    if (i != 0) {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        // Second pass: Set elements to zero based on the marks in the first row and column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // If the first element of the row or column is zero, set the element to zero
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle the first column separately, if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // Handle the first row separately, if needed
        if (row0 == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}



(0, 0) is used as part of the marking process, so we skip it in the second pass to avoid corrupting our markers before we've finished processing the rest of the matrix.
We handle the first row and column separately after the second pass based on the flags set during the marking phase.
