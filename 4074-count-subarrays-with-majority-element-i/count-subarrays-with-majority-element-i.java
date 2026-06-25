class Solution {
    public int countMajoritySubarrays(int[] arr, int t) {
        
        int res = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == t) cnt++;
                else cnt--;

                res += cnt > 0 ? 1 : 0;
            }
        }

        return res;
    }
}