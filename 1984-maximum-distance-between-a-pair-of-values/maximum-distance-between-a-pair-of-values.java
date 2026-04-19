class Solution {
    public int maxDistance(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int n = arr1.length, m = arr2.length;
        int mx = 0;

        while (i < n && j < m) {

            if (arr1[i] <= arr2[j]) {
                mx = Math.max(mx, j - i);
                j++;
            } else {
                i++;
            }
        }

        return mx;
    }
}