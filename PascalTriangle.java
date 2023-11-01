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






