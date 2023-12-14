class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            int sum = 0;
            while(n != 0){
                int ans = n % 10;
                sum += ans*ans;
                n = n/10;
            }
            n = sum;
        }
        return (n == 1);
    }
}
