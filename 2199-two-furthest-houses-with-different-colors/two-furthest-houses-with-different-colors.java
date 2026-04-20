class Solution {
    public int maxDistance(int[] arr) {
        int n = arr.length;
        int mx = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (arr[i] != arr[j]) {
                    mx = Math.max(mx, j - i);
                }
            }
        }

        return mx;
    }
}