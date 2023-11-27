class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> trolly = new ArrayList<>();
        if(digits == null || digits.length() == 0) 
            return trolly;
        helper(trolly,keys,digits,"",0);
        return trolly;
    }
    public void helper(List<String> trolly,String[] keys,String digits,String res,int start){
        if(start >= digits.length()){
            trolly.add(res);
            return;
        }
        String letters = keys[digits.charAt(start)-'0'];
        for(int i = 0;i < letters.length(); i++){
            helper(trolly,keys,digits,res+letters.charAt(i),start+1);
        }
    }
}





class Solution {
    public List<String> letterCombinations(String digits) {
        //String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[][] keys = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> trolly = new ArrayList<>();
        if(digits == null || digits.length() == 0) 
            return trolly;
        helper(trolly,keys,digits,"",0);
        return trolly;
    }
    public void helper(List<String> trolly,char[][] keys,String digits,String res,int start){
        if(start == digits.length()){
            trolly.add(res);
            return;
        }
        char[] letters = keys[digits.charAt(start)-'0'];
        for(int i = 0;i < letters.length; i++){
            helper(trolly,keys,digits,res+letters[i],start+1);
        }
    }
}



USING STRINGBUILDER - MORE FASTER 



class Solution {
    public List<String> letterCombinations(String digits) {
        //String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[][] keys = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> trolly = new ArrayList<>();
        if(digits == null || digits.length() == 0) 
            return trolly;
        helper(trolly,keys,digits,new StringBuilder(),0);
        return trolly;
    }
    public void helper(List<String> trolly,char[][] keys,String digits,StringBuilder sb,int start){
        if(start == digits.length()){
            trolly.add(new String(sb));
            return;
        }
        char[] letters = keys[digits.charAt(start)-'0'];
        System.out.println("letters "+String.valueOf(letters));
        for(int i = 0;i < letters.length; i++){
            sb.append(letters[i]);
            helper(trolly,keys,digits,sb,start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}    
