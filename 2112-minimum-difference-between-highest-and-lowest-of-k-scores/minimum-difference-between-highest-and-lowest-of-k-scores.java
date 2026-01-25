class Solution {
    public int minimumDifference(int[] arr, int w) {
        
        Arrays.sort(arr);
        int dif = (int) 1e9, n = arr.length;

        for (int i = 0; i < n - w + 1; i++) {
            
            int cur = 0, l = i, r = i + w - 1;
            while (l <= r) {
                cur = Math.max(cur, arr[r--] - arr[l++]);
            }

            dif = Math.min(cur, dif);
        }

        return dif;
    }
}
