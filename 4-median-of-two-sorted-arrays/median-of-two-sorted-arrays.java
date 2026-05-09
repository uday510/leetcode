class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        
        if (arr2.length < arr1.length) 
            return findMedianSortedArrays(arr2, arr1);


        int n = arr1.length, m = arr2.length;
        int total = n + m, target = (n + m + 1) >> 1;
        int l = 0, r = n;

        while (l <= r) {

            int p1 = (l + r) >> 1, p2 = target - p1;
            int l1 = safeGet(p1 - 1, arr1), r1 = safeGet(p1, arr1);
            int l2 = safeGet(p2 - 1, arr2), r2 = safeGet(p2, arr2);

            if (l2 > r1)
                l = p1 + 1;
            else if (l1 > r2)
                r = p1 - 1;
            else if (l1 <= r2 && l2 <= r2)  {
                double median = -1;

                if ( (total & 1) == 1) 
                    median = Math.max(l1, l2);
                else 
                    median = ( Math.max(l1, l2) + Math.min(r1, r2) ) / 2.0;
                
                return median;
            }
        }

        return -1;
    }

    private int safeGet(int idx, int[] arr) {
        if (idx < 0) return Integer.MIN_VALUE;
        if (idx >= arr.length) return Integer.MAX_VALUE;
        return arr[idx];
    }
}