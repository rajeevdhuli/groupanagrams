class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean p = true, q = true, r = true, s = true;
        for(int i =0; i < n; i++){
            for(int j = 0 ; j< n; j++){
                if(mat[i][j] != target[j][n-i-1])
                   p = false;
                if(mat[i][j] != target[n-i-1][n-j-1])
                   q = false;
                if(mat[i][j] != target[n-j-1][i])
                   r = false; 
                if(mat[i][j] != target[i][j])
                   s = false;        
            }
        }
        return ( p || q || r || s);
    }
}
