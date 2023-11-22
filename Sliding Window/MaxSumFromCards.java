class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum+= cardPoints[i];
            
        }
        int cur = sum;
        for(int i = 0; i < k; i++){
            cur+=cardPoints[n-i-1] - cardPoints[k-i-1];
            sum = Math.max(sum,cur);
        }
        return sum;
        
    }
}
