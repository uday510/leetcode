class Solution {
    public int getMinDistance(int[] arr, int t, int st) {
        int min = arr.length;

        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] == t) {
                min = Math.min(min, Math.abs(idx - st));
            }
        }

        return min;
    }
}