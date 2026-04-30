#include <vector>
using namespace std;

class Solution {
public:
    void rotate(vector<vector<int>>& arr) {
        int n = arr.size();
        int m = arr[0].size();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (auto& row : arr) {
            int i = 0, j = row.size() - 1;
            while (i < j) {
                swap(row[i], row[j]);
                i++;
                j--;
            }
        }
    }
};