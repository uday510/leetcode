class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    private int solve(int[] arr, int k) {

        int l = 0, cnt = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > k && l <= r) {
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                
                l++;
            }

            cnt += (r - l + 1);
        }

        return cnt;
    }
}