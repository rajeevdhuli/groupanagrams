class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int[] ans = new int[queries];
    for(int i = 0 ; i < queries; i++){
        int idx = indices[i];
        int cur = arr[idx];
        int cnt = 0 ;
        for(int j = idx + 1; j < N; j++){
            if(arr[idx] < arr[j]){
                cnt++;
            }
        }
        ans[i] = cnt;
    }
     return ans;
  }
}
     
