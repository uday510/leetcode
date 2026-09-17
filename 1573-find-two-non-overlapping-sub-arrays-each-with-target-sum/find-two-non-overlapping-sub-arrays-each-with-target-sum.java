class Solution {
    public int minSumOfLengths(int[] arr, int t) {
        int n = arr.length, mx = Integer.MAX_VALUE;
        int[] pf = new int[n + 1];
        Arrays.fill(pf, mx);

        int sm = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (sm == t) {
                pf[j - 1] = j - i;
            }

            sm += arr[j];
            while (sm > t && i < j) {
                sm -= arr[i];
                i++;
            }

            if (sm == t && j == n - 1) {
                pf[n - 1] = j - i; 
            }

        }  

        sm = 0;
        int[] sf = new int[n + 1];
        Arrays.fill(sf, mx);
        for (int i = n - 1, j = n - 1; i > -1; i--) {
            sm += arr[i];
            while (sm > t && i < j) {
                sm -= arr[j];
                j--;
            }

            if (sm == t) {
                if (i > 0) sf[i - 1] = j - i + 1;
            }
        }
        
        for (int i = 1; i < n; i++) pf[i] = Math.min(pf[i], pf[i - 1]);
        for (int i = n - 1; i >= 0; i--) sf[i] = Math.min(sf[i], sf[i + 1]); 

        int mn = mx;
        for (int i = 0; i <= n; i++) {
            if (pf[i] != mx && sf[i] != mx) {
                mn = Math.min(mn, pf[i] + sf[i]);
            }
        }

        return mn == mx ? -1 : mn;
    }
}