class Solution {
    public boolean isGood(int[] arr) {
        
        int n = arr.length;
        int[] cnt = new int[n + 1];

        int mx = arr[0];
        for (int a : arr) {
            if (a > n) return false;
            cnt[a]++;
            mx = Math.max(mx, a);
        }
        
        if (cnt[mx] != 2) return false;

        for (int i = 1; i < n; i++) {
            if (i != mx && cnt[i] != 1) return false;
        }

        return true;

    }
}
