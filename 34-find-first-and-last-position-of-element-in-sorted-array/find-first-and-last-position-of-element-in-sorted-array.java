class Solution {
    public int[] searchRange(int[] arr, int t) {
        int l = bs(arr, t);
        if (l >= arr.length || arr[l] != t) 
            return new int[] {-1, -1};
        
        int r = bs(arr, t + 1) - 1;
        return new int[] {l, r};
    }

    private int bs(int[] arr, int t) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + ((r - l) >> 1);

            if (arr[m] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}