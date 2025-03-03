class Solution {
    Map<Integer, Integer> map;
    int maxId;
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        map = new HashMap<>();
        maxId = 0;

        merge(nums1);
        merge(nums2);

        var result = new ArrayList<int[]>();

        for (int idx = 0; idx < maxId; ++idx) {
            if (map.containsKey(idx + 1)) {
                result.add(new int[]{idx + 1, map.get(idx + 1)});
            }
        }

        var arr = new int[result.size()][2];
        for (int idx = 0; idx < result.size(); ++idx) {
            arr[idx] = result.get(idx);
        }

        return arr;
    }

    private void merge(int[][] nums) {
        for (int[] arr : nums) {
            map.merge(arr[0], arr[1], Integer::sum);
            maxId = Math.max(arr[0], maxId);
        }
    }
}