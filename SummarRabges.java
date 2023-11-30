class Solution {
    public List<String> summaryRanges(int[] arr) {
        int n = arr.length;
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n - 1 && arr[j + 1] == arr[j] + 1) {
                j++;
            }
            if (j > i) {
                temp.append(arr[i]).append("->").append(arr[j]);
            } else {
                temp.append(arr[i]);
            }
            ans.add(temp.toString());
            temp.setLength(0);
            i = j;
        }
        return ans;   
    }
}
