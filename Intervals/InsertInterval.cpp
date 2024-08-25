Brute Force -

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> v  ;
        intervals.push_back(newInterval);
        sort(intervals.begin(),intervals.end());
        int n = intervals.size();
        for(int i = 0;  i < n ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!v.empty() && end <= v[v.size()-1][1])
               continue;
            for(int j = i + 1; j < n ; j++){
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

Optimal Approach - 

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> vec; // This will store the final result
        int n = intervals.size(); // Number of intervals
        bool added = false; // Flag to check if the new interval has been added
        int i = 0; // Index to iterate through the intervals
        
        // Loop through all the intervals
        for(i = 0; i < n; i++){
            int start = intervals[i][0]; // Start of the current interval
            int end = intervals[i][1]; // End of the current interval
            
            // Check if the new interval overlaps with the current interval
            if(newInterval[0] <= end && newInterval[1] >= start){
                // Merge the intervals by updating start and end
                end = max(end, newInterval[1]);
                start = min(start, newInterval[0]);
                vec.push_back({start, end}); // Add the merged interval to the result
                added = true; // Mark that new interval has been added
                break; // Exit the loop since new interval is now added
            }
            // Check if new interval should be placed before the current interval
            else if(newInterval[0] <= end && newInterval[1] < start){
                vec.push_back({newInterval[0], newInterval[1]}); // Add new interval to the result
                // Add the remaining intervals to the result
                while(i < n){
                    vec.push_back({intervals[i][0], intervals[i][1]});
                    i++;
                }
                return vec; // Return the result as all intervals are processed
            }
            // If no overlap and new interval comes after the current interval, just add the current interval
            else {
                vec.push_back({start, end});
            }
        }
        
        // If the new interval was merged earlier, continue merging overlapping intervals
        if(added){
            while(i < n && intervals[i][0] <= vec.back()[1]){
                // Update the end of the last interval in vec if it overlaps with current interval
                vec.back()[1] = max(vec.back()[1], intervals[i][1]);
                i++;
            }
            // Add the remaining intervals that do not overlap
            while(i < n){
                vec.push_back({intervals[i][0], intervals[i][1]});
                i++;
            }   
        }
        
        // If the new interval wasn't added during the loop, add it now
        if(!added){
            vec.push_back({newInterval[0], newInterval[1]});
        }
        
        return vec; // Return the final result containing all intervals
    }
};
    




Optimized Approach - 

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> vec;
        int i = 0, n = intervals.size();
        
        // Step 1: Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            vec.push_back(intervals[i]);
            i++;
        }
        
        // Step 2: Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = min(newInterval[0], intervals[i][0]);
            newInterval[1] = max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        vec.push_back(newInterval);
        
        // Step 3: Add all intervals that come after the new interval
        while (i < n) {
            vec.push_back(intervals[i]);
            i++;
        }
        
        return vec;
    }
};
