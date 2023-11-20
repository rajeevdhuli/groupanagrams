class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0 ;
        int j = n - 1;
        while( i < j){
            if(vowel(ch[i]) && vowel(ch[j])){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j]  = temp;
                i++;
                j--;
            }
            else if(vowel(ch[i])){
                j--;
            }
            else if(vowel(ch[j])){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        String str = new String(ch);
        return str;
        
    }
    public static boolean vowel(char c){
        return (c == 'a'|| c == 'e' || c == 'o' || c == 'i' || c == 'u'||c == 'A'|| c == 'E' || c == 'I' || c == 'O' || c == 'U' );
    }
}
