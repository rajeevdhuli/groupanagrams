import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        ArrayList<Integer> ar=new ArrayList<>();
        int n=a.length;
        int m=b.length;
        int i=0,j=0;
        while(i < n && j < m)
        {  
            if(a[i]!=b[j])
            {
                if(a[i] < b[j])
                {
                    if(ar.size()==0||ar.get(ar.size()-1)!=a[i])       //if list is zero it will directly add, otherwise it will take top elemnt from list and compare it with the present array ele to make sure they are not same.
                    ar.add(a[i]);
                    i++;
                }
                else
                {
                    if(ar.size()==0||ar.get(ar.size()-1)!=b[j])
                    ar.add(b[j]);
                    j++;
                }
            }
            else{
                if(ar.size()==0||ar.get(ar.size()-1)!=a[i])
                ar.add(a[i]);
                i++;
                j++;
            }
        }
        while(j<m)             //remainig left out elemnts in b.
        {
            if(ar.size()==0||ar.get(ar.size()-1)!=b[j])
            ar.add(b[j]);
            j++;
        }
        while(i<n)           //remainig left out elemnts in a.
        {
            if(ar.size()==0||ar.get(ar.size()-1)!=a[i])
            ar.add(a[i]);
            i++;
        }
        return ar;
    }
}
