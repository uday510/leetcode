class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, res = 0;

        for (int a : arr) {
            if (a > res) {
                res++;
            }
        }

        return res;
    }

}