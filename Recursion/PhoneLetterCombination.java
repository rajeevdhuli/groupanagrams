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
