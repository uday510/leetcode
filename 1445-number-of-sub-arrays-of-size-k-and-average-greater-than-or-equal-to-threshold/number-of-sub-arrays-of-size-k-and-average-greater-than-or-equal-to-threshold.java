class Solution {
    public int numOfSubarrays(int[] arr, int k, int t) {
        
        int sumK = 0, cnt = 0, n = arr.length;

        for (int i = 0; i < k && i < n; i++) {
            sumK += arr[i];
        }

        cnt += (sumK / k) >= t ? 1 : 0;


        for (int i = k; i < n; i++) {
            sumK -= arr[i - k];
            sumK += arr[i];

            cnt += (sumK / k) >= t ? 1 : 0;
        }

        return cnt;
    }
}

/**

[2,2,2,2,5,5,5,8] k = 3, t = 4

 */