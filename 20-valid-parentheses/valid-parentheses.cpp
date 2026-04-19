class Solution {
public:
    bool isValid(string s) {
        unordered_map<char, char> map = {
            {')', '('},
            {'}', '{'},
            {']', '['}
        };

        stack<char> st;

        for (char ch : s) {
            if (map.find(ch) == map.end()) {
                st.push(ch);
            } else {
                if (st.empty() || map[ch] != st.top()) {
                    return false;
                }
                st.pop();
            }
        }

        return st.empty();
    }
};