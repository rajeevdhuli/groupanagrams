class Solution {
    public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        vector<vector<int>> v;
        int n = points.size();
        int arrow = points[0][1];
        int cnt = 1;
        for(int i = 1 ;i < n ; i++){
            if(arrow >= points[i][0]){
                arrow  = min(arrow,points[i][1]);   
            }else{
                arrow = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
};
