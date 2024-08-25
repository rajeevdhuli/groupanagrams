JAVA - 
Time Complexity: O(n log n) + O(2N) 
Space Complexity: O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        //comparator sorting - compares based on first value
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> list = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0 ; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j = i + 1; j < n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end,intervals[j][1]);
                    //if you have already added by merging then you have to skip it hence i++;
                    i++;
                }else{
                    break;
                }
            }
            List<Integer> pair = new ArrayList<>();
            pair.add(start);
            pair.add(end);
            list.add(pair);
        }
        // int colSize = (list.isEmpty()) ? 0 : list.get(0).size();
        // you can just insert 2 since it cannot be more than 2
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            // List<Integer> temp = list.get(i);
            // ans[i][0] = temp.get(0);
            // ans[i][1] = temp.get(1);
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}


C++ - 
Time Complexity: O(n log n) + O(2N) 
Space Complexity: O(n)

 class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> vec ;
        for(int i = 0 ; i < intervals.size(); i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j = (i + 1); j < intervals.size() ; j++){
                if(intervals[j][0] <= end){
                    end = max(end,intervals[j][1]);
                    //if you have already added by merging then you have to skip it hence i++;
                    i++;
                }else{
                    break;
                }
            }
            vec.push_back({start,end});
        }
        return vec;
    }
};





O(NLOGN) + O(N) - 


class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> ans;
        int n = intervals.size();
        for(int i = 0; i < n; i++){
            if(ans.empty() ||  ans[ans.size()-1][1] < intervals[i][0]){
                ans.push_back(intervals[i]);
            }else {
                ans[ans.size()-1][1] = max(intervals[i][1],ans[ans.size()-1][1]);
            }
        }
        return ans;
    }
};    
