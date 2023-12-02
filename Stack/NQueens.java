class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),n,0);
        return trolly;
    }
    public void helper(List<List<String>> trolly,List<Integer> boards,int n , int row){
        if(row == n){
            chessBoard( trolly,boards,n);
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(canPlace(boards,row,i,n)){
                boards.add(i);
                helper(trolly,boards,n,row+1);
                boards.remove(boards.size()-1);
            }
        }
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
    public void chessBoard(List<List<String>> trolly,List<Integer> boards,int n){
        List<String> res = new ArrayList<>();
        for(int col: boards){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i++){
                if(i == col){
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(new String(sb));
        }
        trolly.add(res);
    }
}
