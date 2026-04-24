#include <vector>
using namespace std;

class Solution {
private:
    vector<vector<int>> dp;
    vector<int> arr;
    int n;

public:
    int lengthOfLIS(vector<int>& nums) {
        arr = nums;
        n = arr.size();
        dp.assign(n, vector<int>(n + 1, -1));

        return dfs(0, -1);
    }

private:
    int dfs(int cur, int prev) {
        if (cur >= n) {
            return 0;
        }

        if (dp[cur][prev + 1] != -1) {
            return dp[cur][prev + 1];
        }

        int skip = dfs(cur + 1, prev);

        int take = 0;
        if (prev == -1 || arr[prev] < arr[cur]) {
            take = 1 + dfs(cur + 1, cur);
        }

        return dp[cur][prev + 1] = max(skip, take);
    }
};