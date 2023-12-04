class Solution {
    public String tictactoe(int[][] moves) {
        String[][] matrix = new String[3][3];
        //fill the baord with A / B
        for(int i= 0; i < moves.length ; i++){
            String player = (i % 2 == 0) ? "A" : "B";
            matrix[moves[i][0]][moves[i][1]] = player;
        }

        for(int i = 0; i < 3 ; i++){
            //Check Row is Same
            if(( matrix[i][0] == matrix[i][1] ) && ( matrix[i][1] == matrix[i][2] ) && ( matrix[i][0] != null )){
                return matrix[i][0];
            }
            //Check Column is Same
            if(( matrix[0][i] == matrix[1][i] ) && ( matrix[1][i] == matrix[2][i] ) && ( matrix[0][i] != null)){
                return matrix[0][i];
            }
        }

        // Check for Left Diagnol
        if(( matrix[1][1] == matrix[0][0]) && (matrix[1][1] == matrix[2][2]) && (matrix[1][1] != null )){
            return matrix[1][1];
        }

        //Check for Right Diagnol
        if ((matrix[1][1] == matrix[2][0]) && (matrix[1][1] == matrix[0][2]) && ( matrix[1][1] != null )){
            return matrix[1][1];   
        } 

        return (moves.length == 9) ? "Draw" : "Pending";  
        
    }
}










class Solution {
  public String tictactoe(int[][] moves) {
    int[][] row = new int[2][3];
    int[][] col = new int[2][3];
    int[] diag1 = new int[2];
    int[] diag2 = new int[2];

    for (int i = 0; i < moves.length; ++i) {
      int r = moves[i][0];
      int c = moves[i][1];
      int j = i % 2;
      if (++row[j][r] == 3 || ++col[j][c] == 3 || r == c && ++diag1[j] == 3 ||
          r + c == 2 && ++diag2[j] == 3)
        return j == 0 ? "A" : "B";
    }

    return moves.length == 9 ? "Draw" : "Pending";
  }
}
