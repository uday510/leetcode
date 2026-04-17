class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        
        int arr[n + m];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            arr[m + i] = nums2[i];
        }

        sort(arr, arr + (m + n));

        for (int i = 0; i < (n + m); i++) {
            nums1[i] = arr[i];
        }
    }
};