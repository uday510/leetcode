class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        vector<vector<int>> res;
        int n = arr.size();

        for (int i = 0; i < n; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1, k = n - 1;

            while (j < k) {

                int cur = arr[i] + arr[j] + arr[k];

                if (cur < 0) {
                    j++;
                } else if (cur > 0) {
                    k--;
                } else {

                    res.push_back({arr[i], arr[j], arr[k]});

                    j++;
                    k--;

                    // skip duplicates for j
                    while (j < k && arr[j] == arr[j - 1]) j++;

                    // skip duplicates for k
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }

        return res;
    }
};