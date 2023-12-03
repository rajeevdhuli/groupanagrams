class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m - 1;
        int up = 0, down = n - 1;
        List<Integer> res = new ArrayList<>();
        while(left <= right && up <= down){
            for(int i = left; i <= right ; i++){
                res.add(matrix[up][i]);
            }
            up++;
            for(int i = up; i <= down ; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(up <= down){
                for(int i = right; i >= left; i--){
                    res.add(matrix[down][i]);
                }
            }
            down--;
            if(left <= right){
                for(int i =down; i >= up; i--){
                    res.add(matrix[i][left]);
                }
            }
            left++;

        }
        return res;
    }
}
