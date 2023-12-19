class Solution {
    public String largestOddNumber(String num)
    {
        int maxnum = 0;
        String str="";
        int n = num.length();
        for(int i = num.length() - 1; i>=0; i--)
        {   
            if((int)num.charAt(i) % 2 == 1)
            {
                str = num.substring(0,i+1);
                break;
            }
        }
        return str;
    }

}
