O(M*N) , O(2(M+N));

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[] oneRow = new int[m];
        int[] zeroRow = new int[m];
        int[] oneCol = new int[n];
        int[] zeroCol = new int[n];
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 1){
                    oneRow[i]++;
                    oneCol[j]++;
                }
                else if(grid[i][j] == 0){
                    zeroRow[i]++;
                    zeroCol[j]++;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = (oneRow[i] + oneCol[j]) - ( zeroRow[i] + zeroCol[j] );
            }
        }
        return ans;
        
    }
}




O(M*N) , O(M+N);
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[] oneRow = new int[m];
        int[] oneCol = new int[n];
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                oneRow[i]+= grid[i][j]; //no of 1s in row
                oneCol[j]+= grid[i][j]; // no of 1s in col
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //zeros in rowi = length of row  - one's in rowi
                //zeros in coli = length of col - one's in coli
                ans[i][j] = (oneRow[i] + oneCol[j]) - (m - oneRow[i]) - (n - oneCol[j]);
            }
        }
        return ans; 
    }
}
