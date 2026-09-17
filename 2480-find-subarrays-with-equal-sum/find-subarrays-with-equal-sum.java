class Solution {
    public boolean findSubarrays(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        Map<Integer, Integer> cnts = new HashMap<>();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int cur = arr[i] + arr[i - 1];
            if (cnts.merge(cur, 1, Integer::sum) == 2) {
                return true;
            }
        }

        return false;
    }
}