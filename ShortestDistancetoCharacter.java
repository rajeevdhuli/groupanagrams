O(N*L) , (N) -

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< n; i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int l = list.size();
        for(int i = 0 ;i < n ; i++){
            int dis = Integer.MAX_VALUE;
            for(int j = 0 ;j < l ;j ++){
                dis = Math.min(dis,Math.abs(i - list.get(j)));
            }
            ans[i] = dis;
        }
        return ans;
    }
}


O(N),O(N) -


class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< n; i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int l = list.size();
        int p1 = 0;
        int p2 = (l > 1) ? 1 : 0;
        for(int i = 0; i < n; i++){
            int v1 = list.get(p1);
            int v2 = list.get(p2);
            if(i <= v1){
                ans[i] = (v1 -i);
            }else if ( i > v1 && i <= v2){
                if(i - v1 <= v2 - i){
                    ans[i] = (i - v1);
                }else{
                    ans[i]  = (v2 - i);
                    p1++;
                    p2 = p2 < (l-1) ? p2+1 :p2;
                }
            }else{
                ans[i] = (i - v2);
            }
        }
        return ans;
    }
}


