class Solution {
    public int maxDistance(int[] arr1, int[] arr2) {
        
        int mx = 0;
        int n = arr1.length;

        for (int i = 0; i < n; i++) {

            int idx = bs(i, arr1, arr2);
            mx = Math.max(mx, Math.abs(i -  idx) - 1);
        }

        return mx;
    }

    private int bs(int i, int[] arr1, int[] arr2) {

        int l = i, r = arr2.length;


        while (l < r) {

            int m = l + ((r - l) >> 1);

            if (arr1[i] <= arr2[m]) l = m + 1;
            else r = m;
        }

        return l;
    }
}
