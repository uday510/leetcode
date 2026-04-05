class Solution {
    public int hIndex(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];

        for (int a : arr) {
            cnt[Math.min(a, n)]++;
        }

        int cur = 0;

        for (int i = n; i > -1; i--) {
            cur += cnt[i];

            if (cur >= i) {
                return i;
            }

        }
        
        return -1;
    }
}

//   0  1  2  3  5
//  [1  1  0  1  2]

// 3