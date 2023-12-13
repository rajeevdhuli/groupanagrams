class Solution {
    public String removeDigit(String number, char digit) {
        int index = 0,n=number.length();
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                index = i;
                if(i<n-1 && digit < number.charAt(i+1)) break;
            }
        }
        number = number.substring(0, index) + number.substring(index+1,n);
        return number;
    }
}



example -    133235 
     removing first 3 - 13235
     removinf second 3 - 13235
     removing three 3 - 13325

    so you have to remove digit which is always less than next digit.
