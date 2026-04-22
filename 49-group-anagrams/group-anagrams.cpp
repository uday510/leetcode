#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;

        for (string s : strs) {

            string key = s;

            sort(key.begin(), key.end());

            mp[key].push_back(s);
        }

        vector<vector<string>> result;
        
        for (auto& pair : mp) {
            result.push_back(pair.second);
        }

        return result;
    }
};


/**


input: ["eat","tea","tan","ate","nat","bat"]

1. key = sort(str[i])
2. map[key].push(str[i])

---
k = abt

map:{
    aet: [eat, tea, ate]
    ant: [tan, nat]
    abt: [bat]
}

return map.values()



**/