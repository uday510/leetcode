class Solution {
    public int minPairSum(int[] arr) {
        Arrays.sort(arr);
        int min = 0;

        for (int l = 0, r = arr.length - 1; l < r;) {
            min = Math.max(
                min,
             arr[l++] + arr[r--]);
        }

        return min;
    }

}