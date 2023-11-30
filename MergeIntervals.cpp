class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> ans;
        int n = intervals.size();
        for(int i = 0; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!ans.empty() && end <= ans[ans.size()-1][1])
                continue;
            for(int j = i + 1; j < n ; j++){
                if(end >= intervals[j][0]){
                    end = max(end,intervals[j][1]);
                }
                else{
                    break;
                }
            }
            ans.push_back({start,end});
        }
        return ans;
    }
};







class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int n = intervals.size();
        vector<vector<int>> v;
        for(int i = 0; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j = i + 1; j < n; j++){
                if(end >= intervals[j][0]){
                    end = max(end,intervals[j][1]);
                    i++;
                }
                else{
                    break;
                }
            }
            v.push_back({start,end});
        }
        return v;  
    }
};
