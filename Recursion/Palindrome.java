class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> trolly = new ArrayList<>();
        helper(trolly,new ArrayList<>(),s,0);
        return trolly;
    }
    public void helper(List<List<String>> trolly,List<String> bag,String s,int start){
        if(start == s.length()){
           trolly.add(new ArrayList(bag));
           return;
        }
        for(int i = start; i <s.length() ; i++){
            if(isPalindrome(s,start,i)){
                bag.add(s.substring(start,i+1));
                helper(trolly,bag,s,i+1);
                bag.remove(bag.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left,int right){
        while(left<right){
            if(s.charAt(left)!= s.charAt(right))
                return false;
            left++;
            right--;    
        }
        return true;
    }
}
