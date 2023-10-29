Reverse words in a String

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
