class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        //System.out.println("middle "+left +" "+right + " "+s);
        if (right == n && left == n) {
            res.add(s);
            //System.out.println("answer "+left +" "+right + " "+res);
            return;
        }
        
        if (left < n) {
            //System.out.println("before left "+left +" "+right + " "+s);
            recurse(res, left + 1, right, s + "(", n);
            //System.out.println("after left "+left +" "+right + " "+s);
        }
        
        if (right < left) {
            //System.out.println("before right "+left +" "+right + " "+s);
            recurse(res, left, right + 1, s + ")", n);
            //System.out.println("after right "+left +" "+right + " "+s);
        }
    }
	// See above tree diagram with parameters (left, right, s) for better understanding
}



USING STRINGBUILDER - 


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0,new StringBuilder(), n);
        return res;
    }
    public void recurse(List<String> res,int left, int right, StringBuilder sb,int n)  {
        if (right == n && left == n) {
            res.add(new String(sb));
            return;
        }
        if (left < n) {
            sb.append('(');
            recurse(res, left + 1, right, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) {
            sb.append(')');
            recurse(res, left, right + 1, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}	
