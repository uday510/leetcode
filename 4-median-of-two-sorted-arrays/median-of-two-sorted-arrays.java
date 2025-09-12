class Solution {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int n = a1.length, m = a2.length;
        int[] a = merge(a1, a2);

        if (((n + m) & 1) == 0) {
            int idx = (n + m) / 2;
            return (a[idx - 1] + a[idx]) / 2.0;
        }

        return a[(n + m) / 2];
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[n + m];
        
        int i = 0, j = 0, k = 0;
        
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        
        addRemNums(i, k, arr1, res);
        addRemNums(j, k, arr2, res);
        
        return res;
    }
    
    private void addRemNums(int i, int k, int[] src, int[] dest) {
        while (i < src.length) dest[k++] = src[i++];
    }

}