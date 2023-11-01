Genreate pascal triangle upto to specified row  -

O(n^3) -
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> fin = new ArrayList<>();
        for(int row = 1; row <= numRows; row++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int col = 1 ; col <= row; col++)
            {
                int ans = 1;
                for( int i = 0 ; i < col -1; i++)
                {
                    ans = ans * (row - 1 - i);
                    ans = ans / (i + 1);
                }
                temp.add(ans);
            }
            fin.add(temp);
        } 
        return fin;
    }
}

O(n^2) - 
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> fin = new ArrayList<>();
        for(int row = 1; row <= numRows; row++)
        {
            List<Integer> temp = new ArrayList<>();
            int ans = 1;
            temp.add(ans);
            for(int i = 1; i < row; i++)
            {
                ans = ans * ( row - i);
                ans/= i;
                temp.add(ans);
            }
            fin.add(temp);
        }
        return fin;
    }

---------------------------------------------------------------------------------------------------------------------------


Generatr Nth index of pascal triangle -

O(n^2) -

    
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int row  = rowIndex + 1;
        List<Integer> fin = new ArrayList<>();
        for(int col = 1; col <= row; col++)
        {
            long res = 1;
            int r = row - 1;
            for(int i = 0; i < col - 1; i++)
            {
                res = res * (r - i );
                res = res / ( i + 1 );
            }
            fin.add((int)res);
        }
        return fin;
    }
}


O(n) - 



class Solution {
    public List<Integer> getRow(int rowIndex) {
        int row  = rowIndex + 1;
        List<Integer> fin = new ArrayList<>();
        long res = 1;
        fin.add((int)res);
        for(int i = 1; i < row; i++)
        {
            res = res * (row - i );
            res = res / ( i ) ;
            fin.add((int)res);
        }
        return fin;
    }
}    



