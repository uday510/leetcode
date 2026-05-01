class Solution {
    public int maxRotateFunction(int[] arr) {
        int n = arr.length;
        int prev = 0, total = 0;

        for (int i = 0; i < n; i++) {
            prev += i * arr[i];
            total += arr[i];
        }

        int mx = prev;
        for (int i = n - 1; i > -1; i--) {
            int cur = prev + total - (n * arr[i]);
            mx = Math.max(mx, cur);
            prev = cur;
        }

        return mx;
    }
}

/**

[1, 2, 3, 4] 

F(0) = 0*A[0] + 1*A[1] + 2*A[2] + .... + (N - 1) * A[N - 1]
     = 0 + 2 + 6 + 12
     = 20

F(1) = 1*A[0] + 2*A[1] + ... 0*A[N - 1]
     = 1 + 4 + 9 + 0
     = 14

F(1) = F(0) + total_sum - N * A[N - 1]
     = 20 + 10 - 4*4
     = 30 - 16 
     = 14
    


 */