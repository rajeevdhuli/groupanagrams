Reverse words in a String
    
Using stack- O(n) time complexity, O(n) space complecity.
    
Stack<String> st = new Stack<>();
String str = "";
s = s + " ";
for(int i = 0; i < s.length(); i++)
{
    if(s.charAt(i) != ' ')
    {
        str = str + s.charAt(i);
    }
    else
    {
        if(str!= "")
          st.push(str);
        str="";
    }
  }
  String ans = "";
  while(st.size() != 1)
  {
       ans+= st.pop() + " ";
  }
  ans+= st.pop();
  return ans;



without stack , time - O(n) , space - O(1)


class Solution {
    public String reverseWords(String s){
        s = " " + s;
        int left = 0;
        int right =  s.length() - 1;
        String str = "";
        String ans = "";
        while(left <= right)
        {
            if(s.charAt(right) !=  ' ')
            {
                str = s.charAt(right) + str;
            }
            else
            {
                if(str != "")
                   ans+=  str + " ";
                str = "";
            }
            right--;
        }
        //ans = ans.substring(0, ans.length() - 1);
        //ans=ans.trim();
        //return ans;
        return ans.trim();
    }
}    

