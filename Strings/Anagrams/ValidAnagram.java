class Solution
{
   
    public boolean isAnagram(String s, String t) 
    {
        String s1=s.toUpperCase();
        String t1=t.toUpperCase();
        Map<Character,Integer> mp=new HashMap<>();
        if(s1.length()!=t1.length())
           return false;
        for(char c:s1.toCharArray())
        {
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        for(char c:t1.toCharArray())
        {
            if(!mp.containsKey(c))
               return false;
            else
               mp.put(c,mp.get(c)-1);   
        }
        for(int i:mp.values())
        {
            if(i!=0)
               return false;
        }
        return true;
    }
}
