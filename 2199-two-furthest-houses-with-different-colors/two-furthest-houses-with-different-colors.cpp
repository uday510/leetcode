class Solution {
public:
    int maxDistance(vector<int>& arr) {
        int n = arr.size();
        int mx = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (arr[i] != arr[j]) {
                    mx = max(mx, j - i);
                }
            }
        }

        return mx;
    }
};