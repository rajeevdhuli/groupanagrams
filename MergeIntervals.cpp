 O(N*logN) + O(2*N)

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
