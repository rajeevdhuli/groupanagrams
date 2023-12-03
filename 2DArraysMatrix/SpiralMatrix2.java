class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int up = 0, down = n - 1;
        int element = 1;
        List<Integer> res = new ArrayList<>();
        while(left <= right && up <= down){
            for(int i = left; i <= right ; i++){
                matrix[up][i] = element;
                element++;
            }
            up++;
            for(int i = up; i <= down ; i++){
                matrix[i][right] = element;
                element++;
            }
            right--;
            if(up <= down){
                for(int i = right; i >= left; i--){
                    matrix[down][i] = element;
                    element++;
                }
            }
            down--;
            if(left <= right){
                for(int i =down; i >= up; i--){
                    matrix[i][left] = element;
                    element++;
                }
            }
            left++;
        }
        return matrix;
    }
}
