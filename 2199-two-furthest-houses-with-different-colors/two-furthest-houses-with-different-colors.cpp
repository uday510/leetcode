class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();
        int ans = 0;
// 1st house
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0])
                ans = max(ans, i);
// last house
            if (colors[i] != colors[n - 1])
                ans = max(ans, n - 1 - i);
        }

        return ans;
    }
};

/* Find two houses that are far apart AND have different colors

Which two houses give maximum distance AND have different colors  */