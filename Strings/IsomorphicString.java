class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
        int n = s.length();
        Map<Character,Character> mp = new HashMap<>();
        for( int i = 0; i < n; i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if( mp.containsKey(c1)) 
            {
                if(mp.get(c1) != c2 )
                   return false;
            }
            else if ( mp.containsValue(c2))
            {
                return false;
            }
            else
                mp.put(c1,c2);
        }
        return true;

    }
}
