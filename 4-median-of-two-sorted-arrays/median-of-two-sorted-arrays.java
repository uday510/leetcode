class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr2.length < arr1.length) 
            return findMedianSortedArrays(arr2, arr1);
        
        int n = arr1.length, m = arr2.length;
        int total = n + m, target = (total + 1) >> 1;

        int l = 0, r = n;

        while (l <= r) {
            int p1 = (l + r) >> 1, p2 = target - p1;

            int l1 = safeGet(p1 - 1, arr1), r1 = safeGet(p1, arr1);
            int l2 = safeGet(p2 - 1, arr2), r2 = safeGet(p2, arr2);

            if (l1 > r2) r = p1 - 1;
            else if (l2 > r1) l = p1 + 1;
            else if (l1 <= r2 && l2 <= r1) {

                if ( (total & 1) == 1) {
                    return Math.max(l1, l2) * 1.0;
                } 
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
        }

        return -1;
    }

    private int safeGet(int idx, int[] arr) {
        if (idx < 0) return -(int) 1e9;
        if (idx >= arr.length) return (int) 1e9;

        return arr[idx];
    }
}


/**
       l2 r2 
[1, 2, 3, 4] 
    l1 r1
[5, 6, 7]

n = 4 
m = 5
total = 9
target = 5

l = 0, r = 1 
p1 = 0, p2 = 5



l1    r1   
      [1,     2,      3,      4] 
       
                                    l2   r2
    [5,     6,      7,      8,      9]




 */