class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        
    Map<Integer, Integer> cnts = new HashMap<>();
    int mx = 1;

    for (int l = 0, r = 0; r < arr.length; r++) {

        cnts.merge(arr[r], 1, Integer::sum);
        while (l < r && cnts.get(arr[r]) > k) {
            cnts.merge(arr[l], -1, Integer::sum);
            l++;
        }

        mx = Math.max(mx, r - l + 1);
    }

    return mx;
    }
}