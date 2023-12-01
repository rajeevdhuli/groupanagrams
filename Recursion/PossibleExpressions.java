class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> trolly = new ArrayList<>();
        if(num.length() == 0){
            return trolly;
        }
        helper(trolly,"",num,target,0,0,0);
        return trolly;
    }
    public void helper(List<String> trolly,String res,String num, int target,int start,long val,long prev){
        if(start == num.length()){
            if(val == target){
                trolly.add(res);
                return;
            }
        }
        for(int i  = start; i < num.length(); i++){
            if(i > start && num.charAt(start) == '0')
                break;
            Long cur = Long.parseLong(num.substring(start,i+1));
            if(start == 0){
                helper(trolly,res+cur,num,target,i+1,cur,cur);
            }
            else{
                helper(trolly,res+"+"+Long.toString(cur),num,target,i+1,val+cur,cur);
                helper(trolly,res+"-"+Long.toString(cur),num,target,i+1,val-cur,-cur);
                helper(trolly,res+"*"+Long.toString(cur),num,target,i+1,val - prev + prev * cur, prev*cur);
            }
        }
    }
}
