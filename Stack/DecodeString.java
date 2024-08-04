class Solution {
    public String decodeString(String s) {
        // Stack to hold integers for repeat counts
        Stack<Integer> st1 = new Stack<>();
        // Stack to hold intermediate strings
        Stack<String> st2 = new Stack<>();
        int n = s.length();
        
        // Iterate through each character in the string
        for(int i = 0 ; i < n ; i++){
            // If the character is a digit
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0'; // Start forming the number
                // Form the complete number if multiple digits are present
                while(i + 1 < n && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                // Push the number onto stack st1
                if(num != 0)
                    st1.push(num);
            }
            // If the character is '['
            else if(s.charAt(i) == '['){
                // Push the '[' onto stack st2
                st2.push(String.valueOf(s.charAt(i)));
            }
            // If the character is ']'
            else if(s.charAt(i) == ']'){
                String attach = "";
                // Pop characters from stack st2 until '[' is found
                while(!st2.isEmpty() && !st2.peek().equals("[")){
                    attach = st2.pop() + attach;
                }
                // Remove the '[' from stack st2
                st2.pop();
                String repeat = "";
                // Get the repeat count from stack st1
                int cnt = st1.pop();
                // Repeat the string 'attach' cnt times
                for(int j = 0 ; j < cnt; j++){
                    repeat = attach + repeat;
                }
                // Push the repeated string onto stack st2
                st2.push(repeat);
            }
            // If the character is a letter
            else{   
                String temp = "";
                // Collect all contiguous letters
                temp = temp + s.charAt(i); 
                while(i + 1 < n && Character.isLetter(s.charAt(i + 1))){
                    temp = temp + s.charAt(i + 1);
                    i++;
                }
                // Push the collected letters onto stack st2
                if(temp.length() != 0){
                    st2.push(temp);
                }
            }
        }
        
        // Build the final result string from stack st2
        String res = "";
        while(!st2.isEmpty()){
            res = st2.pop() + res;
        }
        
        // Return the final result, or "/" if it's empty
        return (res.length() == 0) ? "/" : res;
    }
}









class Solution {
    public String decodeString(String s) {
        //I will use StringBuilder instead of the String for saving time comp as str works as backup mode while stringBuilder work as snapshot.
        StringBuilder sb=new StringBuilder();
        
        //taking two Stacks which will store number and String which we will multiply later.
        Stack<Integer> nums=new Stack<>();
        Stack<String> str=new Stack<>();
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                int num=ch-'0';
                while(i+1<n && Character.isDigit(s.charAt(i+1)))
                {
                    num=num*10+ s.charAt(i+1)-'0';
                    i++;
                }
                nums.push(num);
            }
            else if(ch=='[')
            {
                str.push(sb.toString());
                //now to emoty sb 
                //i can use two methods set lenth 0 or sb=new Substring but new sub, is slower becuse of new allocation
                sb.setLength(0);
                //sb=new StringBuilder();
            }
            
            else if(ch==']')
            {
                int times=nums.pop();
                StringBuilder temp=new StringBuilder(str.pop());
                for(int x=0;x<times;x++)
                    temp.append(sb);
                
                sb=temp;
            }
            else
                sb.append(ch);
        }
            
        return sb.toString();
    }
}
