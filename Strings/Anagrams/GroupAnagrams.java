JAVA-

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String str : strs)
        {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = Arrays.toString(c);
            //String sorted = new String(c);
            if(!mp.containsKey(sorted))
            {
                ArrayList<String> list = new ArrayList<>();
                mp.put(sorted,list) ;
            }
            mp.get(sorted).add(str);    
        } 
        List<List<String>> values = new ArrayList<>();
        for(List<String> i:mp.values())
        {
            values.add(i);
        }
        return values;
    }
}






class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str : strs)
        {
            int[] freq = new int[26];
            for(char c:str.toCharArray())
            {
                freq[c-'a']++;
            }
            String key=Arrays.toString(freq);
            if(!mp.containsKey(key))
            {
                ArrayList<String> list = new ArrayList<>();
                mp.put(key,list) ;
            }
            mp.get(key).add(str);    
        } 
        List<List<String>> values = new ArrayList<>();
        for(List<String> i:mp.values())
        {
            values.add(i);
        }
        return values;
    }
}



C++


class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> mp;
        for(string str:strs)
        {
            string temp=str;
            sort(str.begin(),str.end());
            if(!mp.count(str))
            {
                vector<string> v;
                mp[str]=v;
            }
            mp[str].push_back(temp);
        }
        vector<vector<string>> ans;
        for(auto it=mp.begin();it!=mp.end();it++)
        {
            ans.push_back(it->second);
        }
        return ans;

    }
}


