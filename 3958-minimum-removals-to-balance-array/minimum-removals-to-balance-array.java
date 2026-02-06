class Solution {
    public int minRemoval(int[] arr, int k) {
        Arrays.sort(arr);
        int mx = 0, n = arr.length;
    
        for (int i = 0, j = 0; j < n; j++) {
            
            while (i < j && arr[j] > (long) k * arr[i]) {
                i++;
            }

            mx = Math.max(mx, j - i + 1);
        }

        return n - mx;
    }
}