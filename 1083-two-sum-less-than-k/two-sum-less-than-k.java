class Solution {
    public int twoSumLessThanK(int[] arr, int k) {
        
        Arrays.sort(arr);

        int l = 0, r = arr.length - 1;
        int mx = -1;

        while (l < r) {
            int cur = arr[l] + arr[r];

            if (cur < k) l++;
            else r--;


            if (cur < k) mx = Math.max(mx, cur);
        }

        return mx;
    }
}