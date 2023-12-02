class Solution {
    public int totalNQueens(int n) {
        List<List<String>> trolly = new ArrayList<>();
        return helper(trolly,new ArrayList<>(),n,0);
    }
    public int helper(List<List<String>> trolly,List<Integer> boards,int n , int row){
        int cnt = 0;
        if(row == n){
            return 1;
        }
        for(int i = 0 ; i < n ; i++){
            if(canPlace(boards,row,i,n)){
                boards.add(i);
                cnt+= helper(trolly,boards,n,row+1);
                boards.remove(boards.size()-1);
            }
        }
        return cnt;
    }
    public boolean canPlace(List<Integer> boards, int row, int col, int n){
        //above checking straigjt line
        for(int i = 0 ; i < boards.size();i++){
            if(boards.get(i) == col)
               return false;
        }
        //right diagnol
        for(int i = row - 1; i >= 0; i--){
            if(boards.get(i) == col + (row - i))
                return false;
        }
        //left diagnol
        for(int i = row - 1; i >= 0; i--){
            if(boards.get(i) == col - (row - i))
                return false;
        }
        return true;
    }
}
