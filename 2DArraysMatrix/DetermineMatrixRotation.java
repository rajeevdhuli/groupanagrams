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
