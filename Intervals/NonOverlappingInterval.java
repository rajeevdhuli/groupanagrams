class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int n = intervals.size();
        int cnt = 0;
        int end = intervals[0][1];
        for(int j =  1; j < n ; j++){
            if(end > intervals[j][0] ){
                cnt++;
                end = min(end,intervals[j][1]);
            }
            else{
                end = intervals[j][1];
            }
        }
        return cnt;
    }
};
