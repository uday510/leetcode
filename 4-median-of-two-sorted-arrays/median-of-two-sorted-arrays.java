class Solution {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int n = a1.length, m = a2.length;
        int[] a = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a1[i] < a2[j]) a[k++] = a1[i++];
            else a[k++] = a2[j++];
        }

        while (i < n) a[k++] = a1[i++];

        while (j < m) a[k++] = a2[j++];

        System.out.println(Arrays.toString(a));

        if ((n + m)% 2 == 0) {
            int idx = (n + m) / 2;
            return (a[idx - 1] + a[idx]) / 2.0;
        }

        return a[(n + m) / 2];
    }
}