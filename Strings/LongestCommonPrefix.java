class Solution {
    public String longestCommonPrefix(String[] str) 
    {
        if (str == null || str.length == 0)
            return "";
        int n = str.length;
        String prefix = str[0];
        int len = prefix.length();
        for( int i = 1; i < n ; i++)
        {
         
            while(str[i].indexOf(prefix,0) != 0 && len >=0)
            {
                len = len - 1;
                prefix = prefix.substring(0, len);
            }
        }
        return prefix;
    }
}



class Solution {
    public String longestCommonPrefix(String[] str) 
    {
        String res  = "";
        Arrays.sort(str);
        char[] c1= str[0].toCharArray();
        char[] c2=str[str.length -1].toCharArray();
        for(int i = 0 ; i< c1.length; i++){
            if(c1[i] != c2[i])
                break;
            res+= c1[i];    
        }
        return res;
    }
}
