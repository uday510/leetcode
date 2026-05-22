class Solution {
    public int search(int[] arr, int t) {
        
        int l = 0, r = arr.length - 1;
        while (l <= r) {

            int m = (l + r) >> 1;
 
            if (arr[m] == t) return m;

            System.out.println(arr[l] + " " + arr[m] + " " + arr[r]);

            if (arr[l] <= arr[m]) {
                if (arr[l] <= t && t < arr[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (arr[m] < t && arr[r] >= t) l = m + 1;
                else r = m - 1;
            }

        }

        return -1;
    }
}