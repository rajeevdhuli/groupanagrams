class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean rot90 = true, rot180 = true, rot270 = true, rot360 = true;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] != target[j][n-i-1])
                    rot90 = false;
                if(mat[i][j] != target[n-i-1][n-j-1])
                    rot180 = false;
                if(mat[i][j] != target[n-j-1][i])
                    rot270 = false;
                if(mat[i][j] != target[i][j])
                   rot360 = false;            
            }
        }
        return (rot90 || rot180 || rot270 || rot360);
    }
}


Alternate by transposing and rotating 



class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        // Try rotating the matrix 0, 90, 180, and 270 degrees
        for (int r = 0; r < 4; r++) {
            if (checkEqual(mat, target)) {
                return true;
            }
            rotate90(mat);
        }
        
        return false;
    }

    // Function to rotate the matrix by 90 degrees clockwise
    private void rotate90(int[][] mat) {
        int n = mat.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
            }
        }
    }

    // Function to check if two matrices are equal
    private boolean checkEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
