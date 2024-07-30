O(N), O(N) - 

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            ans+= (mp.get(s.charAt(i)));
        }
        return ans;
    }
}



O(N) ,O(N) -

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }
        return ans;
    }
}



O(N), O(1) - USING SWITCH CASE -

class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        int num = 0;
        int prev = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            switch(s.charAt(i)){
                case 'I' : num = 1; break;
                case 'V' : num = 5; break;
                case 'X' : num = 10; break;
                case 'L' : num = 50; break;
                case 'C' : num = 100; break;
                case 'D' : num = 500; break;
                case 'M' : num = 1000; break;
            }
            if(num >= prev){
                ans+= num;
            }else{
                ans-= num;
            }
            prev = num;
        }
        return ans;
    }
}
